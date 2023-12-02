package com.example.learnwell

import LearnWellApi
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextClock
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainPageFrag : Fragment() {

    private lateinit var adapter: PostsAdaptor
    private lateinit var recyclerView: RecyclerView

    private val learnWellApi: LearnWellApi by lazy {
        RetrofitClient.retrofit.create(LearnWellApi::class.java)
    }

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

        val searchEditText: EditText = view.findViewById(R.id.searchEditText)

        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                filterPosts(s.toString())
            }
            override fun afterTextChanged(s: Editable) {}
        })

        return view
    }
    fun addNewPost(newPost: Post) {
        postList.add(0, newPost)
        adapter.notifyItemInserted(0)
        recyclerView.scrollToPosition(0)
    }

    private fun filterPosts(text: String) {
        val filteredList = postList.filter {
            it.postTitle.contains(text, ignoreCase = true) ||
                    it.postContent.contains(text, ignoreCase = true) ||
                    it.course.contains(text, ignoreCase = true) ||
                    it.availability.contains(text, ignoreCase = true)||
                    it.seeking.contains(text, ignoreCase = true)
        }
        adapter.updateList(filteredList)
    }
}