package com.example.basic_1.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.basic_1.data.repository.ShoppingRepository

@Suppress("UNCHECKED_CAST")
class ShoppingVMFactory(
    private val repository: ShoppingRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShoppingVM(repository) as T
    }

}