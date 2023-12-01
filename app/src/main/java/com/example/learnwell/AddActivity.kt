package com.example.learnwell

import LearnWellApi
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.Switch
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class AddActivity : AppCompatActivity() {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://your-backend-url/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    private val learnWellApi: LearnWellApi by lazy {
        retrofit.create(LearnWellApi::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val titleEditText: EditText = findViewById(R.id.editTextTitle)
        val contentEditText: EditText = findViewById(R.id.editTextContent)
        val courseEditText: EditText = findViewById(R.id.editTextCourse)
        val availabilityEditText: EditText = findViewById(R.id.editTextAvailability)
        val switch: Switch = findViewById(R.id.switch1)
        val postButton: Button = findViewById(R.id.button)

        postButton.setOnClickListener {
            val newPost = Post(
                titleEditText.text.toString(),
                contentEditText.text.toString(),
                courseEditText.text.toString(),
                availabilityEditText.text.toString(),
                if (switch.isChecked) "Tutee" else "Tutor"
            )

            lifecycleScope.launch {
                try {
                    val response = learnWellApi.createPost(newPost)
                    if (response.isSuccessful) {
                        finish()
                    } else {
                        finish()
                    }
                } catch (e: Exception) {
                    val returnIntent = Intent()
                    returnIntent.putExtra("NEW_POST", newPost)
                    setResult(Activity.RESULT_OK, returnIntent)
                    finish()
                }
            }
        }

        val goBackIcon: ImageView = findViewById(R.id.goBackIcon)
        goBackIcon.setOnClickListener {
            finish()
        }
    }
}
