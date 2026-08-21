package com.foodgo.navigation.navigator

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation3.runtime.NavKey

object NoOpNavigator : Navigator {
    override fun push(route: NavKey) {
        warning("push($route)")
    }

    override fun replaceAll(route: NavKey) {
        warning("replaceAll($route)")
    }

    override fun pop() {
        warning("pop()")
    }
}

private fun warning(action: String) {
    Log.e("NoOpNavigator", "$action called without Navigator provided")
}

val LocalNavigator = staticCompositionLocalOf<Navigator> { NoOpNavigator }

@Composable
fun localNavigator(): Navigator = LocalNavigator.current