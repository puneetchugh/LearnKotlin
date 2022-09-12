package com.example.learningkotlin.sectionOne

import kotlin.random.Random

object Chapter4 {

    //if else-if doesn't necessarily need to have an else block
    val TAG = "${Chapter4::class.java}:"
    val TOTAL_ALPHABETS = 26

    data class TrieNode(var name: String?, val children: Array<TrieNode?>)

    fun createTrie() {
        val parentTrie = TrieNode(null, Array(TOTAL_ALPHABETS) { null })
        insertName("puneet", parentTrie)
        insertName("chugh", parentTrie)

        println("$TAG Finding if name puneet exists: ${findName("puneet", parentTrie)}")
        println("$TAG Finding if name chugh exists: ${findName("chugh", parentTrie)}")
        println("$TAG Finding if name stanley exists: ${findName("stanley", parentTrie)}")

    }

    private fun findName(name: String, parentNode: TrieNode): Boolean {
        var localNode = parentNode
        for (index in name.indices) {
            println("$TAG finding name $name, character ${name[index]}")
            val charIndex = name[index] - 'a'

            if (localNode.children[charIndex] == null) {
                return false
            }
            localNode = localNode.children[charIndex]!!
        }
        return localNode.name == name
    }

    private fun insertName(name: String, parentNode: TrieNode) {
        var localNode = parentNode
        for (index in name.indices) {
            println("$TAG Inserting name $name, character ${name[index]}")
            val charIndex = name[index] - 'a'

            if (localNode.children[charIndex] == null) {
                localNode.children[charIndex] = TrieNode(null, Array(TOTAL_ALPHABETS) { null })
            }
            localNode = localNode.children[charIndex]!!
            if (index == name.length - 1) {
                localNode.name = name
                break
            }
        }
    }

    fun loops() {
        var counter = 0
        while (counter < 10) {
            println("$TAG Trying $counter time : ${Random(counter).nextInt(10)}")
            counter++
        }

        //do-while loop will execute at least once and the condition checking is at the end
        //It could be used for intial data initializations where at least it need to try once
        do {
            println("$TAG It will execute at least once")
        } while (false)
    }


    fun ifElseExpression() {
        val booleanValue = true
        val string = if (booleanValue) "I'm true" else "I'm false"
        println("$TAG Printing string value : $string")
    }


    fun shortCircuit() {
        val trueBoolean = true
        val falseBoolean = false

        val num1 = 5
        val num2 = 8

        println("$TAG checkIfGreater() : ${checkIfGreater(falseBoolean, num1, num2)}")
        println("$TAG checkIfLesser() : ${checkIfLesser(trueBoolean, num1, num2)}")

    }

    private fun checkIfGreater(extraBoolean: Boolean, num1: Int, num2: Int): Boolean {
        //if the value of extraBoolean is false and since the expression is AND(&&)
        //the entire expression cannot be true as it sees extraBoolean to be false,
        //so it doesn't need to check the whole expression
        return extraBoolean && num1 > num2
    }

    private fun checkIfLesser(extraBoolean: Boolean, num1: Int, num2: Int): Boolean {
        //if extraBoolean is true, then the whole expression will be true
        return extraBoolean || num1 < num2

    }

}