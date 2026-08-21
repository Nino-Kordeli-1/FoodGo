package com.foodgo.domain.model

data class MenuItem(
    val id: Int,
    val name: String,
    val price: Double,
    val imageRes: Int?,
    val description: String,
    val category: FoodCategory
)

enum class FoodCategory {
    PIZZA,
    SALAD,
    DRINK
}