package com.binance.ticker.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat

val BinanceYellow = Color(0xFFF0B90B)
val BinanceDark = Color(0xFF0B0E11)
val BinanceSurface = Color(0xFF1E2329)
val BinanceCard = Color(0xFF2B3139)
val BinanceTextPrimary = Color(0xFFEAECEF)
val BinanceTextSecondary = Color(0xFF848E9C)
val BinanceGreen = Color(0xFF0ECB81)
val BinanceRed = Color(0xFFF6465D)
val BinanceBorder = Color(0xFF2E3440)

private val DarkColorScheme = darkColorScheme(
    primary = BinanceYellow,
    onPrimary = BinanceDark,
    surface = BinanceSurface,
    background = BinanceDark,
    onBackground = BinanceTextPrimary,
    onSurface = BinanceTextPrimary,
    surfaceVariant = BinanceCard,
    onSurfaceVariant = BinanceTextSecondary,
    outline = BinanceBorder,
    error = BinanceRed,
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFC99400),
    onPrimary = Color.White,
    surface = Color(0xFFF5F5F5),
    background = Color.White,
    onBackground = Color(0xFF1E2329),
    onSurface = Color(0xFF1E2329),
    surfaceVariant = Color(0xFFEEEEEE),
    onSurfaceVariant = Color(0xFF474D57),
    outline = Color(0xFFDDDDDD),
    error = BinanceRed,
)

val TickerTypography = Typography(
    headlineLarge = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        letterSpacing = (-0.5).sp
    ),
    headlineMedium = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        letterSpacing = (-0.3).sp
    ),
    titleMedium = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 16.sp),
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.15.sp
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.25.sp
    ),
    bodySmall = TextStyle(fontWeight = FontWeight.Normal, fontSize = 12.sp, letterSpacing = 0.4.sp),
    labelMedium = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        letterSpacing = 0.5.sp
    ),
)

@Composable
fun BinanceTickerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = TickerTypography,
        content = content
    )
}