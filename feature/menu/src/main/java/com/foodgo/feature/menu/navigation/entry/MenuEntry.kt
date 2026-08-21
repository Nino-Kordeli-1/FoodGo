package com.foodgo.feature.menu.navigation.entry

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.foodgo.feature.menu.screen.MenuScreen
import com.foodgo.navigation.navigator.Navigator
import com.foodgo.navigation.route.FoodGoRoute

fun EntryProviderScope<NavKey>.menuEntry(navigator: Navigator) {
    entry<FoodGoRoute.Menu> {
        MenuScreen(
            onCartClick = { navigator.push(FoodGoRoute.Cart) }
        )
    }
}