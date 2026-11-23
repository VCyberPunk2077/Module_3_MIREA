package ru.mirea.module3kotlin.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Forest,
    onPrimary = Color.White,
    primaryContainer = Seafoam,
    onPrimaryContainer = Ink,
    secondary = Coral,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFFFE2D7),
    onSecondaryContainer = Color(0xFF4F251E),
    tertiary = Color(0xFF596C8D),
    background = Sand,
    onBackground = Ink,
    surface = Paper,
    onSurface = Ink,
    surfaceVariant = Color(0xFFE6E9E1),
    onSurfaceVariant = MutedInk,
)

private val DarkColors = darkColorScheme(
    primary = NightTeal,
    onPrimary = Color(0xFF00382F),
    primaryContainer = NightCard,
    onPrimaryContainer = NightInk,
    secondary = NightCoral,
    onSecondary = Color(0xFF5C2114),
    secondaryContainer = Color(0xFF56372F),
    onSecondaryContainer = Color(0xFFFFDAD0),
    tertiary = Color(0xFFB9C8EA),
    background = Color(0xFF0F201E),
    onBackground = NightInk,
    surface = NightSurface,
    onSurface = NightInk,
    surfaceVariant = NightCard,
    onSurfaceVariant = Color(0xFFB8CCC5),
)

@Composable
fun Module3Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = AppTypography,
        shapes = AppShapes,
        content = content,
    )
}

