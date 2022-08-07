package composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun RequiredClock(
    modifier: Modifier = Modifier,
    clock: Float = 100f,
    onClockChange: (Float) -> Unit,
) {
    RoundedRow {
        Text(
            modifier = modifier.padding(textPadding),
            text = "Required Clock:"
        )
        FloatField(
            modifier = Modifier.background(Color.LightGray),
            value = clock,
            onValueChange = onClockChange,
            readOnly = true
        )
    }
}
