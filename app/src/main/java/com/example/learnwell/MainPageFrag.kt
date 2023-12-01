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

    private lateinit var adapter: PostsAdaptor
    private lateinit var recyclerView: RecyclerView

    companion object {
        fun newInstance() = MainPageFrag()
    }

    private val postList = mutableListOf(
        Post(postTitle = "Math Problem Set", postContent = "help!", course = "MATH2940", availability = "Mondays,Tuesdays", seeking = "Tutor"),
        Post(postTitle = "Help with ORIE3500", postContent = "help!", course = "ORIE3500", availability = "Mondays,Fridays", seeking = "Tutor"),
        Post(postTitle = "Struggling with Chem", postContent = "help!", course = "CHEM2080", availability = "Mondays", seeking = "Tutor"),
        Post(postTitle = "Help with CS1110", postContent = "help!", course = "CS1110", availability = "after 5pm", seeking = "Tutor"),
        Post(postTitle = "ORIE Prelim Coming up", postContent = "help!", course = "ORIE3300", availability = "Saturdays", seeking = "Tutor"),
        Post(postTitle = "Help with CS2800", postContent = "help!", course = "CS2800", availability = "Thursdays", seeking = "Tutor")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_frag, container, false)

        recyclerView = view.findViewById<RecyclerView>(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(context)

        adapter = PostsAdaptor(postList)
        recyclerView.adapter = adapter

        return view
    }
    fun addNewPost(newPost: Post) {
        postList.add(0, newPost)
        adapter.notifyItemInserted(0)
        recyclerView.scrollToPosition(0)
    }
}