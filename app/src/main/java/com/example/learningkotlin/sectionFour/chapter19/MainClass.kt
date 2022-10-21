package com.example.learningkotlin.sectionFour.chapter19

object MainClass {

    val TAG = "${MainClass::class.java}:"

    fun chapter19Method() {
        println("$TAG ${getClassName()}")
    }

}