package com.foodgo.domain.model

data class CartItem(
    val id: Int,
    val name: String,
    val price: Double,
    val imageRes: Int?,
    val quantity: Int
) {
    val total: Double get() = price * quantity
}