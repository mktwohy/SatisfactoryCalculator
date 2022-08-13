package composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchBar(
    text: String,
    onTextChange: (String) -> Unit
) {
    val textStyle = remember {
        TextStyle(color = Color.White, fontSize = 18.sp)
    }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimension.TopBarHeight)
            .background(color = Color.LightGray),
    ) {
        val searchIconWidth = 45.dp
        val textFieldWidth = this.maxWidth - searchIconWidth

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BasicTextField(
                modifier = Modifier
                    .padding(5.dp)
                    .width(textFieldWidth),
                value = text,
                onValueChange = onTextChange,
                singleLine = true,
                textStyle = textStyle,
                decorationBox = { innerTextField ->
                    if (text.isEmpty()) {
                        Text(
                            text = "Search for recipe...",
                            style = textStyle
                        )
                    }
                    innerTextField()
                }
            )
            Icon(
                modifier = Modifier
                    .width(textFieldWidth)
                    .fillMaxHeight()
                    .padding(5.dp),
                imageVector = Icons.Filled.Search,
                contentDescription = "search",
                tint = FicsitColor.TextColor
            )
        }
    }
}