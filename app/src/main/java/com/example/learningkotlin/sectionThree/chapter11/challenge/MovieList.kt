package com.example.learningkotlin.sectionThree.chapter11.challenge

data class MovieList(val movieList: List<String>) {
    companion object {
        fun createMovieListInstance(list: List<String>): MovieList {
            return MovieList(list)
        }
    }
}