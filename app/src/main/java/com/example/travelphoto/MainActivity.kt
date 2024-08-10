package com.example.travelphoto

import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var image: ImageView
    private var currentImg = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val next = findViewById<ImageButton>(R.id.btnNext)
        val prev = findViewById<ImageButton>(R.id.btnPrev)

        next.setOnClickListener {
            // next image
            val idCurrentImageString = "pic$currentImg"
            val idCurrentImageInt = resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt) ?: return@setOnClickListener
            image.alpha = 0f

            currentImg = (5 + currentImg + 1) % 5

            val idImageToShowString = "pic$currentImg"
            val idImageToShowInt = resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt) ?: return@setOnClickListener
            image.alpha = 1f
        }
        prev.setOnClickListener {
            // previous image
            val idCurrentImageString = "pic$currentImg"
            val idCurrentImageInt = resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt) ?: return@setOnClickListener
            image.alpha = 0f

            currentImg = (5 + currentImg - 1) % 5

            val idImageToShowString = "pic$currentImg"
            val idImageToShowInt = resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt) ?: return@setOnClickListener
            image.alpha = 1f
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}