package com.example.learnwell

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.bottomNav)

        if (savedInstanceState == null)
            openFragment(MainPageFrag.newInstance())

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_main_page -> {
                    openFragment(MainPageFrag.newInstance())
                    true
                }
                R.id.nav_add -> {
                    val intent = Intent(this, AddActivity::class.java)
                    startActivity(intent)
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
}