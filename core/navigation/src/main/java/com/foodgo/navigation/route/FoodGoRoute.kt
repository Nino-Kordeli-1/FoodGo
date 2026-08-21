package com.foodgo.navigation.route

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class FoodGoRoute : NavKey {
    @Serializable
    data object Menu : FoodGoRoute()

    @Serializable
    data object Cart : FoodGoRoute()
}