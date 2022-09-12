package com.example.learningkotlin.sectionOne

sealed class Post {
    class Status(val text: String) : Post()
    class Video(val url: String, val encoding: String, val timeDuration: Int) : Post()
    class Image(val url: String, val caption: String) : Post()
}
