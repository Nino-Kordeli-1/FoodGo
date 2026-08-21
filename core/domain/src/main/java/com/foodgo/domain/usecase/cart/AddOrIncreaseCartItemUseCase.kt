package com.foodgo.domain.usecase.cart

import com.foodgo.domain.model.CartItem
import com.foodgo.domain.repository.cart.CartItemsRepository

class AddOrIncreaseCartItemUseCase(
    private val repository: CartItemsRepository
) {
    suspend operator fun invoke(item: CartItem) {
        repository.addOrIncrement(item)
    }
}