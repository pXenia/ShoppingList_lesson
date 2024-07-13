package com.example.basic_1.ui

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.basic_1.R
import com.example.basic_1.data.ShoppingItem

class AddItemDialog(context: Context, var addItemListener: AddItemListener): AppCompatDialog(context){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_item)
        findViewById<TextView>(R.id.tvAdd)?.setOnClickListener{
            val name = findViewById<EditText>(R.id.etName)?.text.toString()
            val amount = findViewById<EditText>(R.id.etAmount)?.text.toString()
            if (name.isEmpty() || amount.isEmpty()){
                Toast.makeText(context, "Введите наименование", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val item = ShoppingItem(name = name, amount = amount.toInt())
            addItemListener.onAddButtonClick(item)
            dismiss()
        }
        findViewById<TextView>(R.id.tvCancel)?.setOnClickListener{
            dismiss()
        }
    }

}