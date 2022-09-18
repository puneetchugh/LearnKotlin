package com.example.learningkotlin.sectionThree.chapter11.challenge

class User(val name: String) {

    fun addList(listOfMovies: MovieList) {
        movieMap[name] = listOfMovies
    }

    fun list(): MovieList? {
        return movieMap[name]
    }

    companion object {
        val TAG = "${User::class.java}:"
        val movieMap: MutableMap<String, MovieList> = mutableMapOf()
    }
}