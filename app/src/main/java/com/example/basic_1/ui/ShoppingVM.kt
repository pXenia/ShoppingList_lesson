package com.example.basic_1.ui

import androidx.lifecycle.ViewModel
import com.example.basic_1.data.ShoppingItem
import com.example.basic_1.data.repository.ShoppingRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ShoppingVM(
    private val repository: ShoppingRepository
) : ViewModel() {
    fun upsert(shoppingItem: ShoppingItem) = GlobalScope.launch { repository.upsert(shoppingItem) }
    fun delete(shoppingItem: ShoppingItem) = GlobalScope.launch { repository.delete(shoppingItem) }
    fun getShoppingItems() = repository.getShoppingItems()
}