package data

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver


private data class WebPage(
    val url: String
) {
    companion object {
        private val webDriver = run {
            val geckoProperty = "webdriver.gecko.driver"
            val pathToGecko = "C:\\Users\\Michael\\Downloads\\Program_Setup\\Coding\\geckodriver-v0.31.0-win64\\geckodriver.exe"
            System.setProperty(geckoProperty, pathToGecko)
            FirefoxDriver()
        }

        private fun WebDriver.getHtml(url: String): String {
            get(url)
            return pageSource
        }
    }

    val html: String = webDriver.getHtml(url)
    val doc: Document = Jsoup.parse(html)
}

private fun String.formatForEnum(): String =
    this.uppercase()
        .replace(' ', '_')
        .replace('-', '_')

private fun Pair<String, Float>.formatForEnum(): String =
    "PartIO(Part.${first.formatForEnum()}, ${second}f)"

private data class RecipeInfo(
    val name: String,
    val machine: String,
    val ingredients: List<Pair<String, Float>>,
    val output: Pair<String, Float>
) {
    fun toEnumString(): String {
        val isAlternate = output.first.formatForEnum() != name.formatForEnum()

        val inputs = buildString {
            ingredients.forEachIndexed { i, ingredient ->
                append(ingredient.formatForEnum())
                if (i != ingredients.lastIndex) {
                    append(",\n\t\t\t\t")
                }
            }
        }

        return """
            ${name.formatForEnum()} (
                machine = Machine.${machine.formatForEnum()},
                inputs = listOf(
                    $inputs
                ),
                output = ${output.formatForEnum()},
                isAlternate = $isAlternate
            ),
        """
    }
}

private data class ItemInfo(
    val name: String,
    val recipes: List<RecipeInfo>,
)

private val siteUrl = "https://www.satisfactorytools.com"

private val startPage = WebPage("$siteUrl/codex/items")


private fun getItemUrls(): List<String> {
    val items = startPage.doc.getElementsByClass("card text-center item-card ng-scope")
    return items.map {
        it.getElementsByClass("recipe-name stretched-link ng-binding ng-scope")[0].attr("href")
    }
}

private fun getItemName(itemPage: WebPage): String? =
    itemPage.doc
        .getElementsByClass("card mb-3")
        .firstOrNull()
        ?.getElementsByClass("card-header")
        ?.text()


private fun getItemRecipes(itemPage: WebPage): List<RecipeInfo>? {
    fun Element.getPartData(): List<Pair<String, Float>> =
        this.children()
            .map {
                val name = it
                    .getElementsByTag("a")
                    .attr("href")
                    .removePrefix("/codex/items/")

                val rate = it
                    .getElementsByClass("ng-binding ng-scope")
                    .text()
                    .removeSuffix(" / min")
                    .toFloatOrNull() ?: -1f

                name to rate
            }

    val recipesCard = itemPage.doc.getElementsByClass("card mb-3").firstOrNull { card ->
        val headers = card.getElementsByClass("card-header")
        "Recipes" in headers.map { it.text() }
    }

    val tableRows = recipesCard
        ?.getElementsByClass("table recipe-table table-hover")
        ?.firstOrNull()
        ?.getElementsByTag("tr")
        ?.drop(1)

    return tableRows?.map { row ->
        val tableData = row.getElementsByTag("td")

        val recipeName = tableData[0].text()
        val ingredients = tableData[1].getPartData()
        val products = tableData[2].getPartData()[0]
        val machine = tableData[3]
            .getElementsByTag("a")
            .attr("href")
            .removePrefix("/codex/buildings/")

        RecipeInfo(recipeName, machine, ingredients, products)
    }
}

fun main() {
    val recipeSB = StringBuilder()
    val partSB = StringBuilder()

    for (url in getItemUrls()) {
        Thread.sleep(1000L)
        val itemPage = WebPage("$siteUrl$url")

        val itemName = getItemName(itemPage)
        val itemRecipes = getItemRecipes(itemPage)

        if (itemName != null && itemRecipes != null) {
            val itemInfo = ItemInfo(
                name = itemName,
                recipes = itemRecipes
            )

            itemInfo.recipes.forEach { recipeSB.append(it.toEnumString()) }
            partSB.append("${ itemInfo.name.formatForEnum() },\n")
        }
    }

    println(recipeSB)
    println(partSB)
}