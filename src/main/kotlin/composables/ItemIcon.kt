package composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import data.*

val roundedRectangle = RoundedCornerShape(10.dp)

@Composable
fun Products(
    modifier: Modifier = Modifier,
    recipe: Recipe
) {
    IngredientsOrProducts(
        modifier = modifier,
        title = "Output",
        itemIOs = recipe.products,
        manufacturingDuration = recipe.manufacturingDuration
    )
}

@Composable
fun Ingredients(
    modifier: Modifier = Modifier,
    recipe: Recipe
) {
    IngredientsOrProducts(
        modifier = modifier,
        title = "Input",
        itemIOs = recipe.ingredients,
        manufacturingDuration = recipe.manufacturingDuration
    )
}

@Composable
private fun IngredientsOrProducts(
    modifier: Modifier = Modifier,
    title: String,
    itemIOs: List<RecipeIO>,
    manufacturingDuration: Float,
) {
    Column(
        modifier
            .width(400.dp)
            .background(color = Color.White)
    ) {
        for (itemIO in itemIOs) {
            ItemIO(
                item = itemIO.item,
                amount = itemIO.amount,
                rate = (60 / manufacturingDuration) * itemIO.amount
            )
        }
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = title,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ItemIO(
    modifier: Modifier = Modifier,
    item: Item,
    amount: Int,
    rate: Float
) {
    Box(
        modifier = modifier
            .height(100.dp)
            .background(color = Color.Transparent)
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            ItemImage(item = item)

            Column(
                modifier = Modifier.fillMaxHeight().padding(15.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text("$amount ${item.name}")
                Text("$rate per minute")
            }
        }
    }
}

@Composable
fun ItemImages(
    modifier: Modifier = Modifier,
    items: Collection<Item>,
    maxItemSize: Dp = 100.dp
) {
    val itemWidth = maxItemSize / items.size

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        for (item in items) {
            ItemImage(
                modifier = Modifier.size(itemWidth),
                item = item
            )
        }
    }


}

@Composable
fun ItemImage(
    modifier: Modifier = Modifier,
    item: Item,
) {
    if (item.iconPathIsValid) {
        Image(
            modifier = modifier,
            painter = painterResource(item.iconPath),
            contentDescription = item.name
        )
    } else {
        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Image Not Found",
                style = TextStyle(color = FicsitColor.TextColor, textAlign = TextAlign.Center)
            )
        }
    }
}