package com.example.creativeassistant.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = VeryLightGreen,
    primaryVariant = LightIndigo,
    secondary = Purple200,
    onPrimary = Color.White,
    onSecondary = Color.White
    /* Other default colors to override
background = Color.White,
surface = Color.White,
onPrimary = Color.White,
onSecondary = Color.Black,
onBackground = Color.Black,
onSurface = Color.Black,
*/
)

@Composable
fun CreativeAssistantTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

@Composable
fun GeneratedIdeaCardTheme(content: @Composable () -> Unit) {
    val palette = lightColors(
        background = Purple200,
        onBackground = Color.White
    )
    MaterialTheme(colors = palette, content = content)
}

@Composable
fun UserIdeaCardTheme(content: @Composable () -> Unit) {
    val palette = lightColors(
        background = VeryLightGreen,
        onBackground = Color.White
    )
    MaterialTheme(colors = palette, content = content)
}