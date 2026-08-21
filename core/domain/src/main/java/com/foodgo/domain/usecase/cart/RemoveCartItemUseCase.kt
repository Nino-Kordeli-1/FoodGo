package com.foodgo.domain.usecase.cart

import com.foodgo.domain.repository.cart.CartItemsRepository

class RemoveCartItemUseCase(
    private val repository: CartItemsRepository
) {
    suspend operator fun invoke(id: Int){
        repository.removeItem(id)
    }
}