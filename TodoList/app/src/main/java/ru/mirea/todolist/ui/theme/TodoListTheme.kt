package ru.mirea.todolist.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val TodoColors = lightColorScheme(
    primary = Color(0xFF236A5C),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFBCE5D8),
    onPrimaryContainer = Color(0xFF153C3A),
    secondary = Color(0xFFB85F4B),
    background = Color(0xFFF3EFE5),
    surface = Color(0xFFFFFCF6),
    onSurface = Color(0xFF153C3A),
    onSurfaceVariant = Color(0xFF506361),
)

@Composable
fun TodoListTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = TodoColors, content = content)
}

