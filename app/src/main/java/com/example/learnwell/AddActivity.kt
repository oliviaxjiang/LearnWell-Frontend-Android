package com.example.learnwell

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val goBackIcon: ImageView = findViewById(R.id.goBackIcon)
        goBackIcon.setOnClickListener {
            finish()
        }
    }
}
