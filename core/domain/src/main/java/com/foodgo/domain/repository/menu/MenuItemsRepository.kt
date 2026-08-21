package com.foodgo.domain.repository.menu

import com.foodgo.domain.model.MenuItem


interface MenuItemsRepository {
    fun getMenuItems(): List<MenuItem>
}