// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import ViewModel.recipe
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.isCtrlPressed
import androidx.compose.ui.input.key.key
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.singleWindowApplication
import composables.*
import data.Items
import data.Recipe
import data.Recipes
import javax.swing.text.View


enum class Tab { SELECT_RECIPE, PRODUCTION }

object FicsitColor {
    val Orange = Color(0xFFFA9549)
    val PurpleGray = Color(0xFF5F668C)
}

var text by mutableStateOf("")

object ViewModel {
    var recipe by mutableStateOf<Recipe?>(null)
    var tab by mutableStateOf(Tab.SELECT_RECIPE)

    fun selectRecipe(name: String) {
        recipe = Recipes.get(name)
        tab = Tab.PRODUCTION
    }

    fun rate(amount: Float, manufacturingDuration: Float): Float =
        (60 / manufacturingDuration) * amount
}


@OptIn(ExperimentalComposeUiApi::class)
fun main() = singleWindowApplication(
    onKeyEvent = {
        if (it.isCtrlPressed && it.key == Key.R) {
            reset()
        }
        if (it.key == Key.Enter) {
            calculate()
        }
        true
    }
) {
    MaterialTheme(
        colors = darkColors(
            primary = FicsitColor.Orange,
            onSecondary = Color.LightGray,
            onBackground = Color.LightGray,
            surface = Color.Gray,
            onSurface = Color.LightGray,
            background = Color.Black
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background)
        ) {
            Column {
                Row {
                    Button(onClick = { ViewModel.tab = Tab.SELECT_RECIPE }) {
                        Text("Select Recipe")
                    }
                    Button(onClick = { ViewModel.tab = Tab.PRODUCTION }) {
                        Text("Production")
                    }
                }
                when (ViewModel.tab) {
                    Tab.SELECT_RECIPE -> {
                        LazyColumn {
                            items(
                                Recipes.getAll().filter { (_, recipe) ->
                                    "building-constructor-mk1" in recipe.producedIn ||
                                            "building-assembler-mk1" in recipe.producedIn
                                            "building-manufacturer-mk1" in recipe.producedIn
                                }.toList()
                            ) { (name, recipe) ->
                                Row(
                                    modifier = Modifier
                                        .width(400.dp)
                                        .height(100.dp)
                                        .padding(horizontal = 5.dp, vertical = 2.5.dp)
                                        .background(
                                            color = Color.LightGray,
                                            shape = roundedCornerShape
                                        )
                                        .clickable { ViewModel.selectRecipe(name) },
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    ItemIcon(item = Items.get(recipe.products.first().item)!!)
                                    Text(
                                        modifier = Modifier.padding(20.dp),
                                        text = recipe.name
                                    )
                                }
                            }
                        }
                    }
                    Tab.PRODUCTION -> {
                        Row {
                            recipe?.let {
                                Ingredients(modifier = Modifier.padding(5.dp), recipe = it)
                                Products(modifier = Modifier.padding(5.dp), recipe = it)
                            }
                        }
                    }
                }
            }
        }
    }
}

fun calculate() {
    clock = desiredPpm / output.ppm
}

fun reset() {
    clock = 1f
}