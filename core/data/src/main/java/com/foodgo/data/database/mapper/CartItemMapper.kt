package com.foodgo.data.database.mapper

import com.foodgo.data.database.entity.CartItemEntity
import com.foodgo.domain.model.CartItem

class CartItemMapper {
    fun mapToDomain(cartItemEntity: CartItemEntity): CartItem {
        return CartItem(
            id = cartItemEntity.id,
            name = cartItemEntity.title,
            price = cartItemEntity.price,
            imageRes = cartItemEntity.imageRes,
            quantity = cartItemEntity.quantity,
        )
    }

    fun mapToEntity(cartItem: CartItem): CartItemEntity {
        return CartItemEntity(
            id = cartItem.id,
            title = cartItem.name,
            price = cartItem.price,
            quantity = cartItem.quantity,
            imageRes = cartItem.imageRes
        )
    }
}