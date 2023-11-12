package com.example.contactapp

import ItemAdapter
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var items: ArrayList<ItemModel>
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeItems()
        setupRecyclerView()
        registerForContextMenu(recyclerView)
    }

    private fun initializeItems() {
        items = arrayListOf(
            ItemModel(resources.getIdentifier("img", "drawable", packageName), "TRAN Cong Minh"),
            ItemModel(resources.getIdentifier("img", "drawable", packageName), "MinhTC"),
            ItemModel(resources.getIdentifier("img", "drawable", packageName), "Minh Trần"),
            ItemModel(resources.getIdentifier("img", "drawable", packageName), "John Doe"),
            ItemModel(resources.getIdentifier("img", "drawable", packageName), "Jane Doe"),
            ItemModel(resources.getIdentifier("img", "drawable", packageName), "Alice"),
            ItemModel(resources.getIdentifier("img", "drawable", packageName), "Bob"),
            ItemModel(resources.getIdentifier("img", "drawable", packageName), "Charlie"),
            ItemModel(resources.getIdentifier("img", "drawable", packageName), "David"),
            ItemModel(resources.getIdentifier("img", "drawable", packageName), "Eve"),
            ItemModel(resources.getIdentifier("img", "drawable", packageName), "Frank"),
            ItemModel(resources.getIdentifier("img", "drawable", packageName), "Grace"),
            ItemModel(resources.getIdentifier("img", "drawable", packageName), "Heidi"),
            ItemModel(resources.getIdentifier("img", "drawable", packageName), "Ivan"),
            ItemModel(resources.getIdentifier("img", "drawable", packageName), "Judy"),
            ItemModel(resources.getIdentifier("img", "drawable", packageName), "Mallory"),
            ItemModel(resources.getIdentifier("img", "drawable", packageName), "Niaj"),
            ItemModel(resources.getIdentifier("img", "drawable", packageName), "Oscar"),
            ItemModel(resources.getIdentifier("img", "drawable", packageName), "Peggy"),
            ItemModel(resources.getIdentifier("img", "drawable", packageName), "Rupert"),
            ItemModel(resources.getIdentifier("img", "drawable", packageName), "Sybil"),
            ItemModel(resources.getIdentifier("img", "drawable", packageName), "Trent"),
            ItemModel(resources.getIdentifier("img", "drawable", packageName), "Victor"),
            ItemModel(resources.getIdentifier("img", "drawable", packageName), "Walter")
        )

        while (items.size < 15) {
            items.add(ItemModel(resources.getIdentifier("img", "drawable", packageName), "Name ${items.size + 1}"))
        }
    }

    private fun setupRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view)
        val adapter = ItemAdapter(items)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.sub_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val pos = (item.menuInfo as AdapterView.AdapterContextMenuInfo).position
        return when (item.itemId) {
            R.id.call -> {
                call()
                true
            }

            R.id.sms -> {
                sendMess()
                true
            }

            R.id.mail -> {
                sendEmail()
                true
            }

            else -> super.onContextItemSelected(item)
        }
    }

    private fun sendEmail() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        val emailAddresses = findViewById<TextView>(R.id.gmail).text.toString()

        intent.putExtra(Intent.EXTRA_EMAIL, emailAddresses)
        intent.putExtra(Intent.EXTRA_TEXT, "How are you?")
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun call() {
        val intent = Intent(Intent.ACTION_DIAL)
        val selectedPhoneNumber = findViewById<TextView>(R.id.phone).text

        intent.data = Uri.parse("tel:$selectedPhoneNumber")
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun sendMess() {
        val intent = Intent(Intent.ACTION_SENDTO)
        val selectedPhoneNumber = findViewById<TextView>(R.id.phone).text

        intent.data = Uri.parse("smsto:$selectedPhoneNumber")
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}