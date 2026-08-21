package com.foodgo.navigation.navigator

import androidx.navigation3.runtime.NavKey

interface Navigator {
    fun push(route: NavKey)
    fun replaceAll(route: NavKey)
    fun pop()
}