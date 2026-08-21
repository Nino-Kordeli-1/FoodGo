package com.foodgo.data.database.food_go_database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.foodgo.data.database.converter.Converters
import com.foodgo.data.database.dao.CartItemDao
import com.foodgo.data.database.entity.CartItemEntity

@Database(
    entities = [CartItemEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class FoodGoDatabase : RoomDatabase() {
    abstract fun cartItemDao(): CartItemDao
}