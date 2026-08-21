package com.foodgo.data.database.entity

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_item")
data class CartItemEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val price: Double,
    val quantity: Int,
    @DrawableRes
    val imageRes: Int?
)