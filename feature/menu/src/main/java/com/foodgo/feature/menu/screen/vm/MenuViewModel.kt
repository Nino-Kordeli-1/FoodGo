package com.foodgo.feature.menu.screen.vm

import androidx.lifecycle.viewModelScope
import com.foodgo.base.BaseViewModel
import com.foodgo.domain.mapper.toCartItem
import com.foodgo.domain.usecase.cart.AddOrIncreaseCartItemUseCase
import com.foodgo.domain.usecase.cart.ObserveCartUseCase
import com.foodgo.domain.usecase.menu.GetMenuItemsUseCase
import com.foodgo.feature.menu.contract.MenuUiEvent
import com.foodgo.feature.menu.contract.MenuUiState
import com.foodgo.feature.menu.mapper.toDomainCategory
import com.foodgo.feature.menu.model.FoodFilter
import kotlinx.coroutines.launch

class MenuViewModel(
    private val getMenuItems: GetMenuItemsUseCase,
    private val addOrIncreaseCartItems: AddOrIncreaseCartItemUseCase,
    private val observeCartItems: ObserveCartUseCase
) : BaseViewModel<MenuUiState, MenuUiEvent, Nothing>(
    initialState = MenuUiState()
) {

    init {
        loadMenu()
        observeCart()
    }

    private fun loadMenu() {
        val items = getMenuItems()
        updateState { it.copy(allItems = items, items = items) }
    }

    private fun observeCart() {
        viewModelScope.launch {
            observeCartItems().collect { cartItems ->
                updateState {
                    it.copy(cartItemIds = cartItems.map { cartItem -> cartItem.id }.toSet())
                }
            }
        }
    }

    override fun onEvent(event: MenuUiEvent) {
        when (event) {
            is MenuUiEvent.AddToCart -> {
                viewModelScope.launch {
                    addOrIncreaseCartItems(event.item.toCartItem())
                }
            }
            is MenuUiEvent.SelectCategory -> {
                filterItems(event.filter)
            }
        }
    }

    private fun filterItems(filter: FoodFilter) {
        val category = filter.toDomainCategory()
        updateState { state ->
            val filtered = if (category == null) {
                state.allItems
            } else {
                state.allItems.filter { it.category == category }
            }
            state.copy(selectedFilter = filter, items = filtered)
        }
    }
}