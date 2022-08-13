package composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import data.MachineType
import extensions.formatFromEnum

@Composable
fun MachineSelector(
    machineType: MachineType?,
    onMachineSelect: (MachineType?) -> Unit
) {
    fun formatMachineType(machineType: MachineType?): String =
        machineType?.name?.formatFromEnum() ?: "Any"

    var expanded by mutableStateOf(false)

    Button(onClick = { expanded = !expanded }) {
        Row {
            Text(
                modifier = Modifier.padding(10.dp),
                text = formatMachineType(machineType),
                color = MaterialTheme.colors.onBackground
            )
            DropdownMenu(
                modifier = Modifier.background(color = Color.DarkGray),
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                Text(
                    modifier = Modifier.clickable {
                        onMachineSelect(null)
                        expanded = false
                    },
                    text = "Any",
                )
                for (m in MachineType.values()) {
                    Text(
                        modifier = Modifier.clickable {
                            onMachineSelect(m)
                            expanded = false
                        },
                        text = formatMachineType(m),
                    )
                }
            }
        }
    }
}