package com.foodgo.domain.usecase.cart

import com.foodgo.domain.repository.cart.CartItemsRepository

class DecreaseOrDeleteItemUseCase(
    private val repository: CartItemsRepository
) {
    suspend operator fun invoke(id: Int) {
        repository.decrementOrRemove(id)
    }
}