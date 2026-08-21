package com.foodgo.designsystem

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

data class FoodGoAppTypography(
    val labelSmall: TextStyle,
    val labelMedium: TextStyle,
    val titleLarge: TextStyle,
    val titleMedium: TextStyle,
    val bodyMedium: TextStyle,
    val headlineSmall: TextStyle
)

val FoodGoTypography = FoodGoAppTypography(
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = TextSizing.size10,
        lineHeight = TextSizing.size13
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = TextSizing.size12,
        lineHeight = TextSizing.size16
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = TextSizing.size20,
        lineHeight = TextSizing.size26
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = TextSizing.size16,
        lineHeight = TextSizing.size20
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = TextSizing.size14,
        lineHeight = TextSizing.size18
    ),
    headlineSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = TextSizing.size18,
        lineHeight = TextSizing.size18
    )
)

val LocalFoodGoTypography = staticCompositionLocalOf<FoodGoAppTypography> {
    error("No foodGoAppTypography provided")
}

val LocalFoodGoColors = staticCompositionLocalOf<FoodGoAppColors> {
    error("No foodGoColors provided")
}