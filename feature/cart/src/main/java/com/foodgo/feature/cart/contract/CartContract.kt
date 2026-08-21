package com.foodgo.feature.cart.contract

import com.foodgo.domain.model.CartItem

data class CartUiState(
    val items: List<CartItem> = emptyList()
)

sealed interface CartUiEvent {
    data class AddOrIncrease(val item: CartItem) : CartUiEvent
    data class Decrease(val id: Int) : CartUiEvent
    data class Remove(val id: Int) : CartUiEvent
    data object PlaceOrder : CartUiEvent
}