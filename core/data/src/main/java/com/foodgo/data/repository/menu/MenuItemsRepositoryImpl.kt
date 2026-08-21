package com.foodgo.data.repository.menu

import com.foodgo.data.menu_data.MenuDataSource
import com.foodgo.domain.model.MenuItem
import com.foodgo.domain.repository.menu.MenuItemsRepository

class MenuItemsRepositoryImpl(
    private val menuData: MenuDataSource
) : MenuItemsRepository {
    override fun getMenuItems(): List<MenuItem> =
        menuData.getMenuItems()
}