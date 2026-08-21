package com.foodgo.domain.module

import com.foodgo.domain.usecase.cart.AddOrIncreaseCartItemUseCase
import com.foodgo.domain.usecase.cart.DecreaseOrDeleteItemUseCase
import com.foodgo.domain.usecase.cart.ObserveCartUseCase
import com.foodgo.domain.usecase.cart.RemoveCartItemUseCase
import com.foodgo.domain.usecase.menu.GetMenuItemsUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { ObserveCartUseCase(get()) }
    factory { AddOrIncreaseCartItemUseCase(get()) }
    factory { DecreaseOrDeleteItemUseCase(get()) }
    factory { RemoveCartItemUseCase(get()) }
    factory { GetMenuItemsUseCase(get()) }
}