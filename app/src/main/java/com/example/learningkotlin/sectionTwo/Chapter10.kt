package com.example.learningkotlin.sectionTwo

object Chapter10 {

    val TAG = "${Chapter10::class.java}:"

    //lambdas
    //capturing from the enclosing scope
    //custom sorting with lambdas
    //Iterating over collections with lambdas
    //
    var sumLambda: (Int, Int) -> Int = { num1: Int, num2: Int ->
        Int
        num1 + num2
    }

    val lambdaResult = sumLambda(8, 2)

    //lambda - ShortHand syntax
    val multiplyLambda: (Int, Int) -> Int = { num1, num2 -> num1 * num2 }

    private fun operationOnNumbers(
        num1: Int,
        num2: Int,
        operation: (Int, Int) -> Int
    ): Int {
        return operation(num1, num2)
    }

    fun lambdas() {
        println("$TAG sum lambda result : $lambdaResult)")

        val minusLambda: (Int, Int) -> Int = Int::minus
        println("$TAG minusLambda ${minusLambda(4, 8)}")

        println("$TAG Result of operation sum of 10 and 40 ${operationOnNumbers(10, 40) { num1, num2 -> num1 + num2 }}")
        println("$TAG Result of operation multiply of 10 and 40 ${operationOnNumbers(10, 40) { num1, num2 -> num1 * num2 }}")
        println("$TAG Result of operation division of 10 and 40 ${operationOnNumbers(10, 40) { num1, num2 -> num1 / num2 }}")

        println("$TAG Result of operation Int::plus of 10 and 40 ${operationOnNumbers(10, 40, Int::plus)}")
        println("$TAG Result of operation Int::minus of 10 and 40 ${operationOnNumbers(10, 40, Int::minus)}")
    }

    fun countingLambda(): () -> Int {
        var counter = 0
        //increment counter lambda can capture variables from the enclosing scope like counter
        val incrementCounter: () -> Int = {
            counter += 1
            counter
        }
        return incrementCounter
    }

    fun lambdaAndEnclosingScope() {
        val counter1 = countingLambda()
        val counter2 = countingLambda()

        println("$TAG lambdasAndEnclosingScope, counter1 : ${counter1()}")
        println("$TAG lambdasAndEnclosingScope, counter2 : ${counter2()}")

        println("$TAG lambdasAndEnclosingScope, counter1 : ${counter1()}")
        println("$TAG lambdasAndEnclosingScope, counter1 : ${counter1()}")

        println("$TAG lambdasAndEnclosingScope, counter2 : ${counter2()}")
    }

    fun sorting() {
        val names = arrayOf("Puneet", "Nishu", "Jyoti", "Frank")
        println("$TAG array before sorting ${names.contentToString()}")

        println("$TAG array after sorting ${names.sorted().joinToString()}")
        println("$TAG array after sorting ${names.sorted().reversed().joinToString()}")

        val namesByLength = names.sortedWith(compareBy { -it.length }) // Minus sign is for reverse order
        println("$TAG sorting names by length ${namesByLength.joinToString()}}")
    }

    fun lambdaOperations() {
        val userInput = listOf("Puneet", "08", "1995", "2000")
        val numbers = userInput.map {
            it.toIntOrNull()
        }
        println("$TAG lambdaOperation() numbers : $numbers")

        val number2 = userInput.mapNotNull {
            it.toIntOrNull()
        }
        println("$TAG numbers2 after mapNotNull  $number2")

        val doubleNumbers = listOf("10.0", "10.5", "25", "50.5", "10.5", "25")
        val doublesSum = doubleNumbers.mapNotNull { it.toDouble() }.fold(0.0) { start, num ->
            println("$TAG Inside num1 $start, num2 $num")
            start + num
        }
        println("$TAG Inside lambdaOperations() using fold $doublesSum")

        val doublesSum1 = doubleNumbers.mapNotNull { it.toDouble() }.reduce { start, num ->
            println("$TAG Inside num1 $start, num2 $num")
            start + num
        }
        println("$TAG Inside lambdaOperations() using reduce $doublesSum1")

        val mapAssociateWith: Map<String, Int> = doubleNumbers.associateWith { it.toDouble().toInt() }
        println("$TAG Printing mapAssociateWith $mapAssociateWith")

        val mapAssociateBy: Map<Int, String> = doubleNumbers.associateBy({ it.toDouble().toInt() }, { it })
        println("$TAG Printing mapAssociateBy $mapAssociateBy")

        val mapAssociateBy1: Map<Int, String> = doubleNumbers.associateBy { it.toDouble().toInt() }
        println("$TAG Printing mapAssociateBy $mapAssociateBy1")

        val mapAssociate: Map<Int, String> = doubleNumbers.associate { Pair(it.toDouble().toInt(), it) }
        println("$TAG Printing mapAssociate $mapAssociate")

        //This doesn't replace value if they have dupplicate keys, they are appended to the value which is a list
        val mapGroupBy = doubleNumbers.groupBy { it.toDouble().toInt() }
        println("$TAG Printing mapGroupBy $mapGroupBy")
    }

    fun question() {
        val appRatings = mapOf(
            "Calendar Pro" to arrayOf(1, 5, 5, 4, 2, 1, 5, 4),
            "The Messenger" to arrayOf(5, 4, 2, 5, 4, 1, 1, 2),
            "Socialise" to arrayOf(2, 1, 2, 2, 1, 2, 4, 2)
        )
        println("$TAG Initial map ${appRatings.forEach { println("$TAG ${it.key},${it.value.contentToString()}") }}}")

        val averageRatings = appRatings.map { it.key to it.value.reduce { num1, num2 -> num1 + num2 } / it.value.size }
        println("$TAG averageRatings map $averageRatings")
    }

}