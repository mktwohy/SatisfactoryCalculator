package composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import data.MachineType

@Composable
fun TopBar() {
    Column {
        Row {
            Button(onClick = { AppModel.tab = Tab.SELECT_RECIPE; AppModel.updateRecipes() }) {
                Text("Select Recipe")
            }
            Button(onClick = { AppModel.tab = Tab.PRODUCTION }) {
                Text("Production")
            }
        }
    }
}