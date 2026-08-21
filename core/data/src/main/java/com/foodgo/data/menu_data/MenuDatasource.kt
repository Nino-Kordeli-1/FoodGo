package com.foodgo.data.menu_data

import com.foodgo.domain.model.FoodCategory
import com.foodgo.domain.model.MenuItem

class MenuDataSource {

    fun getMenuItems(): List<MenuItem> = listOf(
        MenuItem(
            id = 1,
            name = "Margherita",
            price = 14.50,
            imageRes = com.foodgo.designsystem.R.drawable.ic_pizza,
            description = "Classic tomato",
            category = FoodCategory.PIZZA
        ),

        MenuItem(
            id = 2,
            name = "Pepperoni",
            price = 16.50,
            imageRes = com.foodgo.designsystem.R.drawable.ic_pizza,
            description = "Classic pepperoni pizza",
            category = FoodCategory.PIZZA
        ),

        MenuItem(
            id = 3,
            name = "Caesar Salad",
            price = 10.50,
            imageRes = com.foodgo.designsystem.R.drawable.ic_salad,
            description = "Crispy lettuce & parmesan",
            category = FoodCategory.SALAD
        ),
        MenuItem(
            id = 4,
            name = "Pepsi",
            price = 14.50,
            imageRes = com.foodgo.designsystem.R.drawable.ic_cola,
            description = "Classic tomato & mozzarella",
            category = FoodCategory.DRINK
        ),
        MenuItem(
            id = 5,
            name = "Primavera",
            price = 26.50,
            imageRes = com.foodgo.designsystem.R.drawable.ic_pizza,
            description = "Classic pesto & mozzarella",
            category = FoodCategory.PIZZA
        ),
        MenuItem(
            id = 6,
            name = "Crazy Salad",
            price = 14.50,
            imageRes = com.foodgo.designsystem.R.drawable.ic_salad,
            description = "Classic tomato & mozzarella",
            category = FoodCategory.SALAD
        )
    )
}