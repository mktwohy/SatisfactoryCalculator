package composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import extensions.formatFromEnum

enum class ScreenTab { SELECT_RECIPE, PRODUCTION }

@Composable
fun TabRow(
    modifier: Modifier = Modifier,
    selectedTab: ScreenTab,
    onSelectedTabChange: (ScreenTab) -> Unit
) {
    Column(
        modifier
            .background(color = Color.DarkGray)
            .fillMaxWidth()
            .height(Dimension.TopBarHeight)
    ) {
        Row(
            modifier = Modifier
                .padding(top = 5.dp, start = 5.dp, end = 5.dp)
        ) {
            Tab(
                tab = ScreenTab.SELECT_RECIPE,
                selected = selectedTab == ScreenTab.SELECT_RECIPE,
                onClick = { onSelectedTabChange(ScreenTab.SELECT_RECIPE) }
            )
            Tab(
                tab = ScreenTab.PRODUCTION,
                selected = selectedTab == ScreenTab.PRODUCTION,
                onClick = { onSelectedTabChange(ScreenTab.PRODUCTION) }
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Gray)
        )
    }
}

@Composable
private fun Tab(
    modifier: Modifier = Modifier,
    tab: ScreenTab,
    selected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = if (selected) Color.Gray else Color.LightGray
    Box(
        modifier = modifier
            .height(30.dp)
            .width(200.dp)
            .background(backgroundColor)
            .clickable { onClick() },
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            modifier = Modifier.padding(start = 20.dp),
            text = tab.name.formatFromEnum(),
            style = TextStyle(
                color = FicsitColor.TextColor,
                fontSize = 18.sp
            )
        )
    }
}