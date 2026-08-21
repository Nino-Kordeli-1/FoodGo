package com.foodgo.feature.cart.navigation.entry

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.foodgo.feature.cart.screen.CartScreen
import com.foodgo.navigation.navigator.Navigator
import com.foodgo.navigation.route.FoodGoRoute

fun EntryProviderScope<NavKey>.cartEntry(navigator: Navigator) {
    entry<FoodGoRoute.Cart> {
        CartScreen(
            onBackClick = { navigator.pop() },
            onBrowseMenuClick = { navigator.pop() },
            onPlaceOrderClick = { navigator.pop() }
        )
    }
}