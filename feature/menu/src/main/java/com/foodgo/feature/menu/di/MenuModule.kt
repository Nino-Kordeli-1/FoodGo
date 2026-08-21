package com.foodgo.feature.menu.di

import com.foodgo.feature.menu.screen.vm.MenuViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val menuModule = module {
    viewModel {
        MenuViewModel(
            getMenuItems = get(),
            addOrIncreaseCartItems = get(),
            observeCartItems = get()
        )
    }
}