package com.foodgo.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.foodgo.data.database.entity.CartItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CartItemDao {
    @Query("SELECT * FROM cart_item")
    fun observeItems(): Flow<List<CartItemEntity>>

    @Query("SELECT * FROM cart_item WHERE id =:id")
    suspend fun getItem(id: Int): CartItemEntity?

    @Query("DELETE FROM cart_item WHERE id =:id")
    suspend fun delete(id: Int)

    @Insert
    suspend fun addItem(item: CartItemEntity)

    @Query("UPDATE cart_item SET quantity = quantity + 1 WHERE id = :id AND quantity < 10")
    suspend fun increase(id: Int)

    @Query("UPDATE cart_item SET quantity = quantity - 1 WHERE id = :id AND quantity >= 1")
    suspend fun decrease(id: Int)
}