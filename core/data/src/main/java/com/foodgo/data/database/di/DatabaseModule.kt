package com.foodgo.data.database.di

import androidx.room.Room
import com.foodgo.data.database.food_go_database.FoodGoDatabase
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            FoodGoDatabase::class.java,
            "food_go_database"
        )
            .build()
    }
    single {
        get<FoodGoDatabase>().cartItemDao()
    }
}