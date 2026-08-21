package com.foodgo.feature.menu.mapper

import com.foodgo.domain.model.FoodCategory
import com.foodgo.feature.menu.model.FoodFilter

fun FoodFilter.toDomainCategory(): FoodCategory? = when (this) {
    FoodFilter.ALL -> null
    FoodFilter.PIZZA -> FoodCategory.PIZZA
    FoodFilter.SALADS -> FoodCategory.SALAD
    FoodFilter.DRINKS -> FoodCategory.DRINK
}