package com.foodgo.feature.menu.contract

import com.foodgo.domain.model.MenuItem
import com.foodgo.feature.menu.model.FoodFilter

data class MenuUiState(
    val allItems: List<MenuItem> = emptyList(),
    val items: List<MenuItem> = emptyList(),
    val selectedFilter: FoodFilter = FoodFilter.ALL,
    val cartItemIds: Set<Int> = emptySet()
) {
    val cartItemCount: Int get() = cartItemIds.size
}

sealed interface MenuUiEvent {
    data class SelectCategory(val filter: FoodFilter) : MenuUiEvent
    data class AddToCart(val item: MenuItem) : MenuUiEvent
}