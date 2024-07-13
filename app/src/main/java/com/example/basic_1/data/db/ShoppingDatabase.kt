package com.example.basic_1.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.basic_1.data.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDatabase: RoomDatabase() {

    abstract fun getShoppingDao(): ShoppingItemDAO

    companion object {
        @Volatile
        private var instance: ShoppingDatabase?  = null
        private var LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK){
                instance ?: createDatabase(context).also {
                    instance = it
                }
            }
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context, ShoppingDatabase::class.java, "ShoppingDatabase.db")
                .build()
    }
}