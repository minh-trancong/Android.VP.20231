package com.example.contactapp

import ItemAdapter
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rates = arrayOf(1.0, 24350.0, 25672.0, 29441.0, 160.0, 17722.0, 674.0, 3315.0)
        val currencies = arrayOf("VND", "USD", "EUR", "GBP", "JPY", "SGD", "THB", "CNY")

        val spinnerFrom = findViewById<Spinner>(R.id.spinner_from)
        [[12]]
        val spinnerTo = findViewById<Spinner>(R.id.spinner_to)

        spinnerFrom.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, currencies) // k
        spinnerTo.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, currencies) // g

        val editAmount = findViewById<EditText>(R.id.edit_amount) // c
        val textResult = findViewById<TextView>(R.id.text_result) // d

        findViewById<Button>(R.id.button_convert).setOnClickListener { // e
            val fromValue = editAmount.text.toString().toDouble() // l
            val rate = rates[spinnerFrom.selectedItemPosition] / rates[spinnerTo.selectedItemPosition] // m
            val toValue = fromValue * rate // t

            textResult.text = "Result: $toValue" // 2
        }
    }
}

