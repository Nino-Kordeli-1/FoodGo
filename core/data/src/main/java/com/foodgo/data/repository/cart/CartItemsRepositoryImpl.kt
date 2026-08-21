package com.foodgo.data.repository.cart

import com.foodgo.data.database.dao.CartItemDao
import com.foodgo.data.database.mapper.CartItemMapper
import com.foodgo.domain.model.CartItem
import com.foodgo.domain.repository.cart.CartItemsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CartItemsRepositoryImpl(
    private val cartDao: CartItemDao,
    private val cartItemMapper: CartItemMapper
) : CartItemsRepository {
    override fun observeCartItems(): Flow<List<CartItem>> =
        cartDao
            .observeItems()
            .map { entities ->
                entities.map { cartItemMapper.mapToDomain(it) }
            }

    override suspend fun addOrIncrement(item: CartItem) {
        val existingItem = cartDao.getItem(item.id)

        if (existingItem == null) {
            cartDao.addItem(cartItemMapper.mapToEntity(item))
        } else {
            cartDao.increase(item.id)
        }
    }

    override suspend fun decrementOrRemove(id: Int) {
        val existingItem = cartDao.getItem(id)
            ?: return

        if (existingItem.quantity > 1) {
            cartDao.decrease(id)
        } else {
            cartDao.delete(id)
        }
    }

    override suspend fun removeItem(id: Int) {
        cartDao.delete(id)
    }
}