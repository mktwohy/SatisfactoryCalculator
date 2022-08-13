package composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import data.MachineType
import data.MachineType.Companion.formattedName
import extensions.formatFromEnum

@Composable
fun MachineSelector(
    machineType: MachineType?,
    onMachineSelect: (MachineType?) -> Unit,
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit
) {
    Box(
        modifier = Modifier
            .width(Dimension.MachineSelectorWidth)
            .height(Dimension.TopBarHeight)
            .background(FicsitColor.Orange)
            .clickable {
                onExpandedChange(!expanded)
                println(expanded)
            }
    ) {
        Text(
            modifier = Modifier.padding(10.dp),
            text = machineType.formattedName,
            color = FicsitColor.TextColor
        )
    }
    DropdownMenu(
        modifier = Modifier
            .width(Dimension.MachineSelectorWidth)
            .background(color = Color.DarkGray),
        expanded = expanded,
        onDismissRequest = { onExpandedChange(false) }
    ) {
        for (m in listOf(null) + MachineType.values()) {
            DropdownMenuItem(
                machineType = m,
                onClick = {
                    onMachineSelect(m)
                    onExpandedChange(false)
                }
            )
        }
    }
}

@Composable
private fun DropdownMenuItem(
    machineType: MachineType?,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(Dimension.MachineSelectorWidth)
            .clickable(onClick = onClick)
    ) {
        Text(machineType.formattedName)
    }
}