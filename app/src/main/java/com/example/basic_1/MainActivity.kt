package com.example.basic_1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.basic_1.data.ShoppingItem
import com.example.basic_1.data.db.ShoppingDatabase
import com.example.basic_1.data.repository.ShoppingRepository
import com.example.basic_1.other.ShoppingItemsAdapter
import com.example.basic_1.ui.AddItemDialog
import com.example.basic_1.ui.AddItemListener
import com.example.basic_1.ui.ShoppingVM
import com.example.basic_1.ui.ShoppingVMFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.kodein.di.Instance
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {
    override val kodein by kodein()
    private val factory: ShoppingVMFactory by instance()
    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingVM::class.java)
        val adapter = ShoppingItemsAdapter(listOf(), viewModel)
        findViewById<RecyclerView>(R.id.rvShoppingItems).layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.rvShoppingItems).adapter = adapter
        viewModel.getShoppingItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener{
            AddItemDialog(this,
                object:  AddItemListener{
                    override fun onAddButtonClick(item: ShoppingItem) {
                        viewModel.upsert(item)
                    }
                }).show()
        }
    }
}