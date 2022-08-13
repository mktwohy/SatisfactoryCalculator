package composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.Recipe

@Composable
fun RecipeThumbnail(
    modifier: Modifier,
    recipe: Recipe,
    onClick: (Recipe) -> Unit
) {
    Box(
        modifier = modifier.clickable { onClick(recipe) },
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight(1 / 3f)
                    .fillMaxWidth(2 / 3f),
                contentAlignment = Alignment.Center
            ) {
                ItemImages(
                    items = recipe.products.map { it.item }
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                modifier = Modifier.padding(horizontal = 2.5.dp),
                text = recipe.name,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = FicsitColor.TextColor,
                    textAlign = TextAlign.Center
                )
            )
            Spacer(modifier = Modifier.height(15.dp))
            Box(modifier = Modifier.height(30.dp)) {
                if (recipe.isAlternate) {
                    AlternateMarker()
                }
            }
        }
    }
}

@Composable
private fun AlternateMarker() {
    Box(contentAlignment = Alignment.TopCenter) {
        Box(
            modifier = Modifier
                .background(
                    color = FicsitColor.Orange,
                    shape = roundedCornerShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                text = "Alt.",
                style = TextStyle(fontSize = 12.sp)
            )
        }
    }
}
