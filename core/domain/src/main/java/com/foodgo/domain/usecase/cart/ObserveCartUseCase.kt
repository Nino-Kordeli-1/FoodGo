package com.foodgo.domain.usecase.cart

import com.foodgo.domain.model.CartItem
import com.foodgo.domain.repository.cart.CartItemsRepository
import kotlinx.coroutines.flow.Flow

class ObserveCartUseCase(
    private val repository: CartItemsRepository
) {
    operator fun invoke(): Flow<List<CartItem>> =
        repository.observeCartItems()
}