package com.example.learnwell
import java.io.Serializable

data class Post (
    var postTitle : String,
    var postContent : String,
    var course : String,
    var availability : String,
    var seeking :String
): Serializable