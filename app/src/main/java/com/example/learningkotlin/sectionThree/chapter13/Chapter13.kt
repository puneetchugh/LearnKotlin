package com.example.learningkotlin.sectionThree.chapter13

import kotlin.math.roundToInt
import kotlin.properties.Delegates


//Extension properties
val Chapter13.extensionProp: Double
    get() = height.toDouble() + width.toDouble()

class Chapter13(var height: Int, var width: Int) {
    companion object {
        @JvmStatic //So now Java code can call TAG as Chapter12CustomGetter.TAG instead of Chapter12CustomGetter.companion.TAG
        val TAG = "${Chapter13::class.java}:"
    }
}

class Chapter13CustomGetter(var height: Double, var width: Double) {
    val diagonal: Int //read-only property
        get() {
            println("$TAG diagonal get() is being called...")
            val result = Math.sqrt(height * height + width * width)
            return result.roundToInt()
        }

    companion object {
        @JvmStatic //So now Java code can call TAG as Chapter12CustomGetter.TAG instead of Chapter12CustomGetter.companion.TAG
        val TAG = "${Chapter13CustomGetter::class.java}:"
    }
}

class Chapter13DelegatedProperties(private val id: Int) {

    companion object {
        @JvmStatic //So now Java code can call TAG as Chapter12CustomGetter.TAG instead of Chapter12CustomGetter.companion.TAG
        val TAG = "${Chapter13DelegatedProperties::class.java}:"
    }

    val myName by lazy { "Puneet Chugh" }
    lateinit var myNameLateInit: String
    var highestLevel = 10
        private set

    var unlocked: Boolean by Delegates.observable(false) { _, old, new ->
        if (new && id > highestLevel) {
            highestLevel = id
        }
        println("$TAG unlocked old: $old and new: $new")
    }

    var unlockedDelegateVetoable: Int by Delegates.vetoable(0) { _, old, new ->
        println("$TAG unlocked old: $old and new: $new")
        new > highestLevel
    }

    fun printing() {
        println("$TAG printing myName lazy property $myName")
        println("$TAG trying to print myNameLateInit is Initialized ${this::myNameLateInit.isInitialized}")
        myNameLateInit = "Chugh"
        println("$TAG After initializing myNameLateInit, trying to print myNameLateInit is Initialized ${this::myNameLateInit.isInitialized}")
        println("$TAG After initializing myNameLateInit, trying to print myNameLateInit is Initialized ${this::myNameLateInit.isInitialized}")
        println("$TAG After initializing myNameLateInit, trying to print myNameLateInit $myNameLateInit")
    }
}