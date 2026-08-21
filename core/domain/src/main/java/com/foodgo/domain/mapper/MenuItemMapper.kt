package com.foodgo.domain.mapper

import com.foodgo.domain.model.CartItem
import com.foodgo.domain.model.MenuItem

fun MenuItem.toCartItem(): CartItem =
    CartItem(
        id = id,
        name = name,
        price = price,
        imageRes = imageRes,
        quantity = 1
    )