package composables

import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FloatField(
    modifier: Modifier = Modifier,
    value: Float,
    onValueChange: (Float) -> Unit,
    readOnly: Boolean = false
) {
    TextField(
        modifier = modifier,
        value = value.toString(),
        onValueChange = {
            onValueChange(it.formatAsNumber().toFloatOrNull() ?: 0f)
        },
        readOnly = readOnly
    )
}

fun String.formatAsNumber(): String {
    var hasSeenDecimal = false

    return buildString {
        for (c in this@formatAsNumber) {
            if (c.isDigit()) {
                append(c)
            }
            if (c == '.') {
                if (!hasSeenDecimal) {
                    append(c)
                    hasSeenDecimal = true
                }
            }
        }
    }
}