package com.example.gmail

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalTime

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mailItems = ArrayList(listOf(
            Mail_item(
                title = "Meeting Reminder",
                context = "Don't forget about the team meeting tomorrow at 10am.",
                receiver = "John Doe",
                LocalTime.now(),
                resources.getIdentifier("avatar", "drawable", packageName)
            ),
            Mail_item(
                title = "Flight Confirmation",
                context = "Your flight to San Francisco on December 15th is confirmed.",
                receiver = "Jane Smith",
                LocalTime.now(),
                resources.getIdentifier("avatar", "drawable", packageName)
            ),
            Mail_item(
                title = "Dinner Reservation",
                context = "Your dinner reservation for 2 at La Petite Maison is confirmed for 7pm tonight.",
                receiver = "Alice Johnson",
                LocalTime.now(),
                resources.getIdentifier("avatar", "drawable", packageName)
            )
        ))

        findViewById<ListView>(R.id.MailContent).adapter = GmailAdapter(mailItems)


    }
}


