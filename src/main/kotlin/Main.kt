import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.isCtrlPressed
import androidx.compose.ui.input.key.key
import androidx.compose.ui.window.singleWindowApplication
import composables.*

@OptIn(ExperimentalComposeUiApi::class)
fun main() = singleWindowApplication(
    onKeyEvent = {
        if (it.isCtrlPressed && it.key == Key.R) {

        }
        if (it.key == Key.Enter) {

        }
        true
    }
) {
    MaterialTheme(
        colors = darkColors(
            primary = FicsitColor.Orange,
            onSecondary = Color.LightGray,
            onBackground = Color.LightGray,
            surface = Color.Gray,
            onSurface = Color.LightGray,
            background = Color.Black
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background)
        ) {
            TabRow(
                modifier = Modifier.fillMaxWidth(),
                selectedTab = Model.tab,
                onSelectedTabChange = { Model.tab = it }
            )
            when (Model.tab) {
                ScreenTab.SELECT_RECIPE -> SelectRecipeScreen()
                ScreenTab.PRODUCTION -> ProductionScreen()
            }
        }
    }
}