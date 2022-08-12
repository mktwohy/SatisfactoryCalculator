package composables

import androidx.compose.material.TextField
import androidx.compose.runtime.Composable

@Composable
fun RecipeSearcher(
    text: String,
    onTextChange: (String) -> Unit
) {
    TextField(
        value = text,
        onValueChange = onTextChange
    )
}