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

@Composable
fun MachineSelector(
    machineType: MachineType?,
    onMachineSelect: (MachineType) -> Unit
) {
    var expanded by mutableStateOf(false)

    RoundedBackground(modifier = Modifier.clickable { expanded = !expanded }) {
        Row {
            Text(
                modifier = Modifier.padding(10.dp),
                text = machineType?.name ?: "Select Machine",
                color = MaterialTheme.colors.onBackground
            )
            DropdownMenu(
                modifier = Modifier.background(color = Color.DarkGray),
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                for (m in MachineType.values()) {
                    Text(
                        modifier = Modifier.clickable {
                            onMachineSelect(m)
                            expanded = false
                        },
                        text = m.name,
                    )
                }
            }
        }
    }
}