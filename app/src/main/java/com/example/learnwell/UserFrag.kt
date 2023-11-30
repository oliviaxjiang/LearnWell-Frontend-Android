package com.example.learnwell

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
//        val text = view.findViewById<TextView>(R.id.textView)
//        text.text = "Welcome to LearnWell"

        return inflater.inflate(R.layout.user_frag, container, false)
    }
}