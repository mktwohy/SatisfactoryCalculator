package composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DesiredPpmSelector(
    ppm: Float,
    onPpmChange: (Float) -> Unit,
) {

    RoundedRow(horizontalArrangement = Arrangement.End){
        Text(
            modifier = Modifier.padding(textPadding),
            text = "Desired Part/Min:"
        )
        FloatField(
            modifier = Modifier.background(MaterialTheme.colors.surface),
            value = ppm,
            onValueChange = onPpmChange
        )
    }
}
