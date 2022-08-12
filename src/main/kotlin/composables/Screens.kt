package composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import data.Recipe

val roundedCornerShape = RoundedCornerShape(10.dp)

@Composable
fun SelectRecipeScreen() {
    LazyColumn {
        items(AppModel.recipes) {
            Recipe(it)
        }
    }
}

@Composable
fun Recipe(recipe: Recipe) {
    Row(
        modifier = Modifier
            .width(400.dp)
            .height(100.dp)
            .padding(horizontal = 5.dp, vertical = 2.5.dp)
            .background(
                color = Color.LightGray,
                shape = roundedCornerShape
            )
            .clickable { AppModel.selectRecipe(recipe.id) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            for (product in recipe.products) {
                ItemIcon(item = product.item)
            }
        }
        Text(
            modifier = Modifier.padding(20.dp),
            text = recipe.name
        )
    }
}

@Composable
fun ProductionScreen() {
    Row {
        AppModel.selectedRecipe?.let {
            Ingredients(modifier = Modifier.padding(5.dp), recipe = it)
            Products(modifier = Modifier.padding(5.dp), recipe = it)
        }
    }
}