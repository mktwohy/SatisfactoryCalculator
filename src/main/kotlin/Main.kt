import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import composables.*


@OptIn(ExperimentalComposeUiApi::class)
fun main() = application {
    Window(
        onCloseRequest = this::exitApplication,
        icon = painterResource(AppIcon.PIONEER_THUMBS_UP),
        title = "Satisfactory Calculator"
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
}