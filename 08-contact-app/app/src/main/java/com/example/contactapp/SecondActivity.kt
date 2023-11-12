package com.example.contactapp

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.Typeface
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        setNameFromIntent()

        val name = intent.getStringExtra("name")
        val firstLetter = name?.get(0).toString()
        val image = createImageWithText(firstLetter)

        val profileImg = findViewById<ImageView>(R.id.profile_img)
        profileImg.setImageBitmap(image)
    }

    // Extracted method to set name from intent
    private fun setNameFromIntent() {
        val nameTextView = findViewById<TextView>(R.id.name)
        val name = intent.getStringExtra("name")
        nameTextView.text = name
    }

    private fun createImageWithText(text: String): Bitmap {
        val bitmap = Bitmap.createBitmap(70, 70, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)

        val bgPaint = Paint()
        bgPaint.color = Color.GRAY
        bgPaint.isAntiAlias = true
        canvas.drawCircle(bitmap.width / 2f, bitmap.height / 2f, bitmap.width / 2f, bgPaint)

        val textPaint = Paint()
        textPaint.color = Color.WHITE
        textPaint.textSize = 30f
        textPaint.isAntiAlias = true
        textPaint.typeface = Typeface.DEFAULT_BOLD

        val bounds = Rect()
        textPaint.getTextBounds(text, 0, text.length, bounds)

        val x = (bitmap.width - bounds.width()) / 2
        val y = (bitmap.height + bounds.height()) / 2

        canvas.drawText(text, x.toFloat(), y.toFloat(), textPaint)

        return bitmap
    }
}