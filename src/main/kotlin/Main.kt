// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.DesktopMaterialTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.isCtrlPressed
import androidx.compose.ui.input.key.key
import androidx.compose.ui.window.singleWindowApplication
import composables.*


object FicsitColor {
    val Orange = Color(0xFFFA9549)
    val PurpleGray = Color(0xFF5F668C)
}

var text by mutableStateOf("")

@OptIn(ExperimentalComposeUiApi::class)
fun main() = singleWindowApplication(
    onKeyEvent = {
        if (it.isCtrlPressed && it.key == Key.R) {
            reset()
        }
        if (it.key == Key.Enter) {
            calculate()
        }
        true
    }
) {
    DesktopMaterialTheme(
        colors = darkColors(
            primary = FicsitColor.Orange,
            onSecondary = Color.LightGray,
            onBackground = Color.LightGray,
            surface = Color.Gray,
            onSurface = Color.LightGray,
            background = Color.Black
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background)
        ) {
            App()
        }
    }
}

fun calculate() {
    clock = desiredPpm / output.ppm
}

fun reset() {
    clock = 1f
}