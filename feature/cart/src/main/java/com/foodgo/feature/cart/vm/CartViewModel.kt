package com.foodgo.feature.cart.vm

import androidx.lifecycle.viewModelScope
import com.foodgo.base.BaseViewModel
import com.foodgo.domain.usecase.cart.AddOrIncreaseCartItemUseCase
import com.foodgo.domain.usecase.cart.DecreaseOrDeleteItemUseCase
import com.foodgo.domain.usecase.cart.ObserveCartUseCase
import com.foodgo.domain.usecase.cart.RemoveCartItemUseCase
import com.foodgo.feature.cart.contract.CartUiEvent
import com.foodgo.feature.cart.contract.CartUiState
import kotlinx.coroutines.launch

class CartViewModel(
    private val observeCartItems: ObserveCartUseCase,
    private val addOrIncreaseCartItems: AddOrIncreaseCartItemUseCase,
    private val removeOrDecreaseCartItems: DecreaseOrDeleteItemUseCase,
    private val removeItem: RemoveCartItemUseCase,
) : BaseViewModel<CartUiState, CartUiEvent, Nothing>(
    initialState = CartUiState()
) {

    init {
        observeCart()
    }

    private fun observeCart() {
        viewModelScope.launch {
            observeCartItems().collect { items ->
                updateState { it.copy(items = items) }
            }
        }
    }

    override fun onEvent(event: CartUiEvent) {
        when (event) {
            is CartUiEvent.AddOrIncrease ->
                viewModelScope.launch { addOrIncreaseCartItems(event.item) }

            is CartUiEvent.Decrease ->
                viewModelScope.launch { removeOrDecreaseCartItems(event.id) }

            is CartUiEvent.Remove ->
                viewModelScope.launch { removeItem(event.id) }

            is CartUiEvent.PlaceOrder ->
                viewModelScope.launch {
                    state.value.items.map { it.id }.forEach { id ->
                        removeItem(id)
                    }
                }
        }
    }
}