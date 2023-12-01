package com.example.learnwell

import com.squareup.moshi.Json
data class User(
    @Json(name = "name") val name: String,
    @Json(name = "netID") val netID: String,
    @Json(name = "userType") val userType: String
)

data class Course(
    @Json(name = "name") val name: String
)
