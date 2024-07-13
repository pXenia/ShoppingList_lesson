package com.example.basic_1.data.repository

import com.example.basic_1.data.ShoppingItem
import com.example.basic_1.data.db.ShoppingDatabase

class ShoppingRepository(
    private val db: ShoppingDatabase
) {
    suspend fun upsert(shoppingItem: ShoppingItem) = db.getShoppingDao().upsert(shoppingItem)
    suspend fun delete(shoppingItem: ShoppingItem) = db.getShoppingDao().delete(shoppingItem)
    fun getShoppingItems() = db.getShoppingDao().getItems()
}