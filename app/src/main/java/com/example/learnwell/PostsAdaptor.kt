package com.example.learnwell

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class PostsAdaptor(
    var postList : List<Post>,
) : RecyclerView.Adapter<PostsAdaptor.MyPostViewHolder>() {

    class MyPostViewHolder(view : View) : ViewHolder(view) {
        val postTitle : TextView = view.findViewById(R.id.postTitle)
        val postContent : TextView = view.findViewById(R.id.postContent)
        val course : TextView = view.findViewById(R.id.courseContent)
        val availability : TextView = view.findViewById(R.id.availabilityContent)
        val seeking : TextView = view.findViewById(R.id.tutorOrTutee)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_cell, parent, false)
        return MyPostViewHolder(view)
    }

    fun updateList(newList: List<Post>) {
        postList = newList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MyPostViewHolder, pos: Int) {
        val post : Post = postList[pos]
        holder.postTitle.text = post.postTitle

        holder.postContent.text = post.postContent

        holder.course.text = post.course

        holder.availability.text = post.availability

        holder.seeking.text = post.seeking

        holder.itemView.setOnClickListener {
//            val intent = Intent(holder.itemView.context, SongDetailActivity::class.java)
//            intent.putExtra("POSITION", pos)
//            intent.putExtra("NAME", song.songName)
//            intent.putExtra("ARTIST", song.songArtist)
//            intent.putExtra("ALBUM", song.songAlbum)
//            intent.putExtra("IMAGE", song.albumImg)
//            (holder.itemView.context as Activity).startActivityForResult(intent, REQUEST_CODE)

        }

    }

    override fun getItemCount(): Int {
        return postList.size
    }
}