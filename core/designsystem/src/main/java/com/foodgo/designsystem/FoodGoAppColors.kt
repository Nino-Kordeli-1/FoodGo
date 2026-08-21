package com.foodgo.designsystem

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class FoodGoAppColors(
    val primaryBlue: Color,
    val badgeRed: Color,
    val addedGreenText: Color,
    val addedGreenBg: Color,

    val textPrimary: Color,
    val textSecondary: Color,
    val bgScreen: Color,
    val cardBg: Color,
    val borderNeutral: Color,
)

val LightFoodGoColors = FoodGoAppColors(
    primaryBlue = Colors.PrimaryBlue,
    badgeRed = Colors.BadgeRed,
    addedGreenText = Colors.AddedGreenText,
    addedGreenBg = Colors.AddedGreenBg,
    textPrimary = Colors.TextPrimary,
    textSecondary = Colors.TextSecondary,
    bgScreen = Colors.BgScreen,
    cardBg = Colors.CardBg,
    borderNeutral = Colors.BorderNeutral
)

@Composable
fun FoodGoAppTheme(
    content: @Composable () -> Unit
) {
    val foodGoColors = LightFoodGoColors
    val foodGoTypography = FoodGoTypography
    CompositionLocalProvider(
        LocalFoodGoColors provides foodGoColors,
        LocalFoodGoTypography provides FoodGoTypography
    ) {
        MaterialTheme(content = content)
    }
}
