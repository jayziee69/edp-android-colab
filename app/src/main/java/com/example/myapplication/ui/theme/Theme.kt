package com.example.myapplication.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF440803),
    onPrimary = Color.White,
    primaryContainer = Color(0xFF341203),
    onPrimaryContainer = Color(0xFFFFDBCF),
    secondary = Color(0xFFFFB5A0),
    surface = Color(0xFF1E1E1E),          // Clean, modern dark surface
    onSurface = Color(0xFFEEEEEE),        // High contrast text
    onSurfaceVariant = Color(0xFFB0B0B0), // Secondary text
    outline = Color(0xFFFF7A59)
)

val LocalBackgroundGradient = staticCompositionLocalOf<Brush> {
    Brush.verticalGradient(listOf(Color.Transparent, Color.Transparent))
}

@Composable
fun ProfileTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else lightColorScheme()

    // Smooth, subtle top glow gradient
    val gradient = if (darkTheme) {
        Brush.verticalGradient(
            colors = listOf(
                Color(0xFFFF5722).copy(alpha = 0.25f),
                Color(0xFF121212)
            ),
            startY = 0f,
            endY = 900f
        )
    } else {
        Brush.verticalGradient(
            colors = listOf(
                Color(0xFFFF5722).copy(alpha = 0.15f),
                Color(0xFFF8F9FA)
            ),
            startY = 0f,
            endY = 900f
        )
    }

    CompositionLocalProvider(LocalBackgroundGradient provides gradient) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}