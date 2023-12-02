package com.example.learnwell

import LearnWellApi
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class RegisterActivity: AppCompatActivity() {
    private val learnWellApi: LearnWellApi by lazy {
        RetrofitClient.retrofit.create(LearnWellApi::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val goBackIcon: ImageView = findViewById(R.id.goBackIcon)
        goBackIcon.setOnClickListener {
            finish()
        }

        val username:EditText = findViewById(R.id.nameContent)
        val netid:EditText = findViewById(R.id.editNetid)


        val registerButton: Button = findViewById(R.id.registerButton)
        registerButton.setOnClickListener {
            val user = User(name = username.text.toString(), netID = netid.text.toString(), userType = "student")

            lifecycleScope.launch {
                try {
                    val response = learnWellApi.createUser(user)
                    if (response.isSuccessful) {
                        finish()
                    } else {
                        finish()
                    }
                } catch (e: Exception) {
                    finish()
                }
            }
        }
    }
}
