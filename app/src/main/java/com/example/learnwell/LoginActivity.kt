package com.example.learnwell

import LearnWellApi
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class LoginActivity: AppCompatActivity() {
    private val learnWellApi: LearnWellApi by lazy {
        RetrofitClient.retrofit.create(LearnWellApi::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText: EditText = findViewById(R.id.inputUsername)
        val netidEditText: EditText = findViewById(R.id.editNetid)
        val loginButton: Button = findViewById(R.id.loginButton)
        val goBackIcon: ImageView = findViewById(R.id.goBackIcon)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val netid = netidEditText.text.toString()

            lifecycleScope.launch {
                try {
//                    val response = learnWellApi.validateUser(netid)
//                    if (response.isSuccessful && response.body() != null) {
//                    } else {
//                    }
                    finish()

                } catch (e: Exception) {
                    finish()
                }
            }
        }

        goBackIcon.setOnClickListener {
            finish()
        }

    }
}