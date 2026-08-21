package com.foodgo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.foodgo.feature.cart.navigation.entry.cartEntry
import com.foodgo.feature.menu.navigation.entry.menuEntry
import com.foodgo.navigation.navigator.LocalNavigator
import com.foodgo.navigation.navigator.DefaultNavigator
import com.foodgo.navigation.route.FoodGoRoute

@Composable
fun FoodGoNavHost(
    modifier: Modifier = Modifier,
    onExit: () -> Unit
) {
    val backStack = rememberNavBackStack(FoodGoRoute.Menu)
    val navigator = remember(backStack) {
        DefaultNavigator(backStack)
    }

    CompositionLocalProvider(
        LocalNavigator provides navigator
    ) {
        NavDisplay(
            backStack = backStack,
            modifier = modifier,
            onBack = {
                if (backStack.size > 1) {
                    navigator.pop()
                } else {
                    onExit()
                }
            },
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator()
            ),
            entryProvider = entryProvider {
                menuEntry(navigator)
                cartEntry(navigator)
            }
        )
    }
}