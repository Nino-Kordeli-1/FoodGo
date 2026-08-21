package com.foodgo.navigation.navigator

import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

class DefaultNavigator(
    private val backStack: NavBackStack<NavKey>
) : Navigator {
    override fun push(route: NavKey) {
        if (backStack.lastOrNull() != route) {
            backStack.add(route)
        }
    }

    override fun replaceAll(route: NavKey) {
        backStack.clear()
        backStack.add(route)
    }

    override fun pop() {
        backStack.removeLastOrNull()
    }
}