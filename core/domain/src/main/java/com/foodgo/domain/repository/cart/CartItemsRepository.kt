package com.foodgo.domain.repository.cart

import com.foodgo.domain.model.CartItem
import kotlinx.coroutines.flow.Flow

interface CartItemsRepository {
    fun observeCartItems(): Flow<List<CartItem>>
    suspend fun addOrIncrement(item: CartItem)
    suspend fun decrementOrRemove(id: Int)
    suspend fun removeItem(id: Int)
}