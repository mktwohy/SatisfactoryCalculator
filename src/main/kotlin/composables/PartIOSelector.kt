package composables

import PartIOState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PartIOSelector(
    partIO: PartIOState,
    clock: Float
) {
    val textFieldBackground = MaterialTheme.colors.surface

    RoundedRow {
        Text(
            modifier = Modifier.padding(textPadding),
            text = "Part:",
        )
        TextField(
            modifier = Modifier.background(color = textFieldBackground),
            value = partIO.name,
            onValueChange = partIO::onNameChange
        )
        Text(
            modifier = Modifier.padding(textPadding),
            text = "Part/Min:"
        )
        FloatField(
            modifier = Modifier.background(color = textFieldBackground),
            value = partIO.ppm * clock,
            onValueChange = partIO::onPpmChange
        )
    }
}