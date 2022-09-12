package com.example.learningkotlin.sectionOne

import kotlin.math.max
import kotlin.math.sqrt

object Chapter2 {

    private val LOG_TAG = Chapter2::class.java.name!!

    val constantName: String = "Puneet Chugh"
    var variableName: String = "Puneet"

    const val compileTimeConstantName = "Compile time constant"

    fun variablesAndConstants() {
        println("$LOG_TAG Constant is $constantName")
        println("$LOG_TAG Variable is $variableName")
        variableName = "Chugh"
        println("$LOG_TAG Variable now $variableName")
    }

    fun mathFunctions() {
        val num = 10
        val move = 2
        println("$LOG_TAG Number $num, moves : $move")
        println("$LOG_TAG Result for shift left ${genericFunction(num, move) { number, moves -> number shl moves }}")
        println("$LOG_TAG Result for shift right ${genericFunction(num, move) { number, moves -> number shr moves }}")

        val funAsVariable = ::findMax
        println("$LOG_TAG Result for max ${genericFunction(num1 = num, num2 = move, ::findMax)})")
        println("$LOG_TAG Result for max ${genericFunction(num1 = num, num2 = move, funAsVariable)})")

        print("$LOG_TAG Result for square root : ${findSqrt(num)}")
    }

    fun findSqrt(input: Int): Double {
        return sqrt(input.toDouble())
    }

    private fun findMax(input1: Int, input2: Int): Int {
        return max(input1, input2)
    }

    //divides the number by 2 to power number of moves
    fun shiftRight(number: Int, moves: Int) {
        println("$LOG_TAG Shifting $number right by $moves gives ${number shr moves}")
    }

    //multiplies the number by 2 to power number of moves
    fun shiftLeft(number: Int, moves: Int) {
        println("$LOG_TAG Shifting $number left by $moves gives ${number shl moves}")
    }

    //performs operation that's received through function on num1 and num2
    private fun genericFunction(num1: Int, num2: Int, function: (number: Int, moves: Int) -> Int): Int {
        return function(num1, num2)
    }

    //Question
    /*Suppose the squares on a chessboard are numbered left to right, top to bottom, with 0 being the top-left
    square and 63 being the bottom-right square. Rows are numbered top to bottom, 0 to 7. Columns are numbered
    left to right, 0 to 7. Declare a constant position and assign it a value between 0 and 63. Calculate the
    corresponding row and column numbers and store the results in constants named row and column*/
    fun solution() {
        val position = (0..63).random() //= Random(0)
        val pair = calculateRowAndCol(position)
        println("$LOG_TAG Position $position is at ${pair.first}, ${pair.second}")
    }

    private fun calculateRowAndCol(position: Int): Pair<Int, Int> {
        val SQUARE_SIZE = 8
        return Pair(((position / SQUARE_SIZE)), (position % SQUARE_SIZE))
    }
}