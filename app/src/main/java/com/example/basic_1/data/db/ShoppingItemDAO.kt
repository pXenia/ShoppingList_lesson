package com.example.basic_1.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.basic_1.data.ShoppingItem

@Dao
interface ShoppingItemDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(shoppingItem: ShoppingItem)
    @Delete
    suspend fun delete(shoppingItem: ShoppingItem)
    @Query("Select * from shopping_items")
    fun getItems(): LiveData<List<ShoppingItem>>
}