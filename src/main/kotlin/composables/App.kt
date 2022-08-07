package composables

import PartIOState
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.Machine

/* todo when have internet:
https://github.com/rhocode/Giraffe/tree/master/src/data/images


 */

val roundedCornerShape = RoundedCornerShape(10.dp)
val textPadding = 20.dp
val rowPadding = 10.dp

// region state
var machine: Machine? by mutableStateOf(Machine.ASSEMBLER)
val input1 = PartIOState("Iron Plates", 20f)
val input2 = PartIOState("Screws", 30f)
val input3 = PartIOState("", 40f)
val input4 = PartIOState("", 50f)
val output = PartIOState("", 10f)
var clock by mutableStateOf(1f)
var desiredPpm by mutableStateOf(100f)
// endregion

val inputs = listOf(input1, input2, input3, input4)

@Composable
@Preview
fun App() {
    val textColor = MaterialTheme.colors.onBackground

    val smallSpacer = @Composable {
        Spacer(Modifier.height(10.dp))
    }

    val largeSpacer = @Composable {
        Spacer(Modifier.height(30.dp))
    }

    Column(
        modifier = Modifier
            .padding(10.dp)
            .verticalScroll(rememberScrollState())
            .width(1000.dp)
    ) {
        MachineSelector(
            machine = machine,
            onMachineSelect = { machine = it }
        )

        val numInput = machine?.numInput ?: 0

        smallSpacer()
        Text("Input:", color = textColor)
        for (input in inputs.take(numInput)) {
            PartIOSelector(input, clock)
        }

        smallSpacer()
        Text("Output:", color = textColor)
        PartIOSelector(output, clock)

        smallSpacer()
        Text("Desired Output:", color = textColor)
        DesiredPpmSelector(
            ppm = desiredPpm,
            onPpmChange = { desiredPpm = it },
        )

        largeSpacer()

        CalculateAndReset()

        smallSpacer()

        RequiredClock(
            modifier = Modifier.fillMaxWidth(),
            clock = clock,
            onClockChange = { clock = it },
        )
    }
}