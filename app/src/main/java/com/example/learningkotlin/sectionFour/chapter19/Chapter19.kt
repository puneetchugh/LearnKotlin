@file:JvmName("Utils")

package com.example.learningkotlin.sectionFour.chapter19

fun getClassName(): String {
    return "Chapter19"
}

fun String.lastTwoChars(): String {
    if (this.length >= 2) {
        return this.substring(this.length - 2 until this.length)
    }
    return this
}
