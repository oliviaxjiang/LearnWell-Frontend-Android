package com.example.learnwell

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextClock
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainPageFrag : Fragment() {

    companion object {
        fun newInstance() = MainPageFrag()
    }

    private val postList = mutableListOf(
        Post(postTitle = "Help with CS2800", postContent = "help!", course = "CS2800", availability = "Mondays"),
        Post(postTitle = "Help with CS2800", postContent = "help!", course = "CS2800", availability = "Mondays"),
        Post(postTitle = "Help with CS2800", postContent = "help!", course = "CS2800", availability = "Mondays"),
        Post(postTitle = "Help with CS2800", postContent = "help!", course = "CS2800", availability = "Mondays"),
        Post(postTitle = "Help with CS2800", postContent = "help!", course = "CS2800", availability = "Mondays"),
        Post(postTitle = "Help with CS2800", postContent = "help!", course = "CS2800", availability = "Mondays")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_frag, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = PostsAdaptor(postList)

        return view
    }
}