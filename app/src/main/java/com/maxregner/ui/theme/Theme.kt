package com.maxregner.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val MaxRegnerColorScheme = darkColorScheme(
    primary = CyanNeon,
    onPrimary = PureBlack,
    secondary = MagentaNeon,
    onSecondary = PureBlack,
    background = PureBlack,
    onBackground = TextPrimary,
    surface = SurfaceDark,
    onSurface = TextPrimary,
    surfaceVariant = CardGlass,
    onSurfaceVariant = TextSecondary,
    outline = CyanSoft.copy(alpha = 0.3f)
)

@Composable
fun MaxRegnerTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = MaxRegnerColorScheme,
        typography = MaxRegnerTypography,
        content = content
    )
}
