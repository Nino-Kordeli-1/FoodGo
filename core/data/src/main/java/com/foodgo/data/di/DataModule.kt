package com.foodgo.data.di

import com.foodgo.data.database.mapper.CartItemMapper
import com.foodgo.data.menu_data.MenuDataSource
import com.foodgo.data.repository.cart.CartItemsRepositoryImpl
import com.foodgo.data.repository.menu.MenuItemsRepositoryImpl
import com.foodgo.domain.repository.cart.CartItemsRepository
import com.foodgo.domain.repository.menu.MenuItemsRepository
import org.koin.dsl.module

val dataModule = module {

    single<CartItemMapper> {
        CartItemMapper()
    }

    single<CartItemsRepository> {
        CartItemsRepositoryImpl(
            cartDao = get(),
            cartItemMapper = get()
        )
    }

    single {
        MenuDataSource()
    }
    single<MenuItemsRepository> {
        MenuItemsRepositoryImpl(
            menuData = get()
        )
    }
}