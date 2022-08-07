package composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import calculate
import reset

@Composable
fun CalculateAndReset() {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Button(
            onClick = { reset() }
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(0.5f),
                text = "Reset",
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }

        Button(
            onClick = { calculate() }
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Calculate",
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
    }
}