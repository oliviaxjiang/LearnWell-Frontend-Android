package com.example.learnwell

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextClock
import android.widget.TextView

class UserFrag : Fragment() {

    companion object {
        fun newInstance() = UserFrag()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.user_frag, container, false)
        val registerButton: Button = view.findViewById(R.id.registerButton)
        registerButton.setOnClickListener {
            val intent = Intent(activity, RegisterActivity::class.java)
            startActivity(intent)
        }
        val loginButton: Button = view.findViewById(R.id.loginButton)
        loginButton.setOnClickListener {
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
        }
        return view
    }
}