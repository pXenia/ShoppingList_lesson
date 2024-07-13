package com.example.basic_1

import android.app.Application
import com.example.basic_1.data.db.ShoppingDatabase
import com.example.basic_1.data.repository.ShoppingRepository
import com.example.basic_1.ui.ShoppingVMFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class App: Application(), KodeinAware{
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@App))
        bind() from singleton {
            ShoppingDatabase(instance())
        }
        bind() from singleton {
            ShoppingRepository(instance())
        }
        bind() from provider {
            ShoppingVMFactory(instance())
        }

    }

}