package com.foodgo.domain.usecase.menu

import com.foodgo.domain.model.MenuItem
import com.foodgo.domain.repository.menu.MenuItemsRepository

class GetMenuItemsUseCase(
    private val repository: MenuItemsRepository
) {
    operator fun invoke(): List<MenuItem> =
        repository.getMenuItems()
}