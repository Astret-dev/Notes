package com.example.notes.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

/*private val DarkColorPalette = darkColors(
    primary = Gold,
    primaryVariant = Gold,
    secondary = Gold,
)

private val LightColorPalette = lightColors(
    primary = Gold,
    primaryVariant = Gold,
    secondary = Gold

    *//* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    *//*
)*/

private val DarkColorPalette = NoteColors(
    background = DarkGray,
    title = Color.White,
    content = Color.White,
    card = Color.Black,
    icons = Color.White,
    primary = Gold
)

private val LightColorPalette = NoteColors(
    background = DarkWhite,
    title = Color.Black,
    content = Gray,
    card = Color.White,
    icons = Color.Black,
    primary = Gold
)


@Composable
fun NotesTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    ProvideNoteColor(colors) {
        MaterialTheme(
            colors = debugColors(darkTheme),
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

@Stable
class NoteColors(
    background: Color,
    title: Color,
    content: Color,
    card: Color,
    icons: Color,
    primary : Color
) {
    var background by mutableStateOf(background)
        private set
    var title by mutableStateOf(title)
        private set
    var content by mutableStateOf(content)
        private set
    var card by mutableStateOf(card)
        private set
    var icons by mutableStateOf(icons)
        private set
    var primary by mutableStateOf(primary)
        private set

    fun update(other: NoteColors) {
        background = other.background
        title = other.title
        content = other.content
        card = other.card
        icons = other.icons
        primary = other.primary
    }

    fun copy(): NoteColors = NoteColors(
        background = background,
        title = title,
        content = content,
        card = card,
        icons = icons,
        primary = primary
    )
}

object NoteTheme {
    val colors: NoteColors
        @Composable
        get() = LocalNoteColors.current
}


@Composable
fun ProvideNoteColor(
    colors: NoteColors,
    content: @Composable () -> Unit,
) {
    val colorPalette = remember {
        // Explicitly creating a new object here so we don't mutate the initial [colors]
        // provided, and overwrite the values set in it.
        colors.copy()
    }
    colorPalette.update(colors)
    CompositionLocalProvider(LocalNoteColors provides colorPalette, content = content)
}

private val LocalNoteColors = staticCompositionLocalOf<NoteColors> {
    error("No JetsnackColorPalette provided")
}

fun debugColors(
    darkTheme: Boolean,
    debugColor: Color = Gold,
) = Colors(
    primary = debugColor,
    primaryVariant = debugColor,
    secondary = debugColor,
    secondaryVariant = debugColor,
    background = debugColor,
    surface = debugColor,
    error = debugColor,
    onPrimary = debugColor,
    onSecondary = debugColor,
    onBackground = debugColor,
    onSurface = debugColor,
    onError = debugColor,
    isLight = !darkTheme
)