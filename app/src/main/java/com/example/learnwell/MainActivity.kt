package com.example.learnwell

import LearnWellApi
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNav: BottomNavigationView

    private val learnWellApi: LearnWellApi by lazy {
        RetrofitClient.retrofit.create(LearnWellApi::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.bottomNav)

        if (savedInstanceState == null) {
            openFragment(MainPageFrag.newInstance())
            fetchPosts()
        }

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_main_page -> {
                    openFragment(MainPageFrag.newInstance())
                    true
                }
                R.id.nav_add -> {
                    val intent = Intent(this, AddActivity::class.java)
                    startActivityForResult(intent, ADD_POST_REQUEST_CODE)
                    true
                }
                R.id.nav_user -> {
                    openFragment(UserFrag.newInstance())
                    true
                }
                else -> false
            }
        }

    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.mainFragmentContainer, fragment)
            commit()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == ADD_POST_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            data?.getSerializableExtra("NEW_POST")?.let { newPostData ->
                val newPost = newPostData as Post
                (supportFragmentManager.findFragmentById(R.id.mainFragmentContainer) as? MainPageFrag)?.addNewPost(newPost)
            }
        }
    }

    companion object {
        private const val ADD_POST_REQUEST_CODE = 1
    }

    private fun fetchPosts() {
        val url = "http://34.86.69.4/api/posts"

        val client = OkHttpClient()
        val request = Request.Builder().url(url).get().build()

        client.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {
                Log.e("MainActivity", "Error fetching posts: ${e.message}")
            }

            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                response.body?.string()?.let { responseBody ->
                    val posts = parsePosts(responseBody)
                }
            }
        })
    }

    private fun parsePosts(json: String): List<Post>? {
        return try {
            val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
            val type = Types.newParameterizedType(List::class.java, Post::class.java)
            val jsonAdapter: JsonAdapter<List<Post>> = moshi.adapter(type)
            jsonAdapter.fromJson(json)
        } catch (e: Exception) {
            Log.e("MainActivity", "Error parsing posts: ${e.message}")
            null
        }
    }
}