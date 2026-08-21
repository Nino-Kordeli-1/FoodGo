package com.foodgo.feature.cart.di

import com.foodgo.feature.cart.vm.CartViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val cartModule = module {
    viewModel {
        CartViewModel(
            observeCartItems = get(),
            addOrIncreaseCartItems = get(),
            removeOrDecreaseCartItems = get(),
            removeItem = get()
        )
    }
}