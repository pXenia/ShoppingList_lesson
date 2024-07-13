package com.example.basic_1.ui

import com.example.basic_1.data.ShoppingItem

interface AddItemListener {
    fun onAddButtonClick(item: ShoppingItem)
}