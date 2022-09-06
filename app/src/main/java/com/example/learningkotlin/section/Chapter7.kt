package com.example.learningkotlin.section

object Chapter7 {
    //Nullables
    //Smart casts
    //Safe calls, not-null assertions
    //Elvis operator

    private val TAG = "${Chapter7::class.java}:"

    fun kotlinNullable() {
        var nullableIntValue: Int? = null
        println("$TAG nullableIntValue ${nullableIntValue ?: -2000}")
        nullableIntValue = 999
        println("$TAG nullableInt Value $nullableIntValue")

        val nonNullIntString = "1001"
        var nullIntString: String? = null

        val parsedNonNull = nonNullIntString.toIntOrNull()
        val parsedNullInt = nullIntString?.toIntOrNull()

        println("$TAG prasedNonNull $parsedNonNull")
        println("$TAG parsedNullInt $parsedNullInt")

        nullIntString = "1400"
        val parsedNullableInt = nullIntString?.toIntOrNull()
        println("$TAG parsedNullableInt $parsedNullableInt, type ${parsedNullableInt!!::class.java.kotlin.qualifiedName}")
    }

    fun kotlinSmartCasts() {
        var personName: String? = null
        kotlinSmarCastsHelper(personName)
        personName = "Puneet Chugh"
        kotlinSmarCastsHelper(personName)
    }

    private fun kotlinSmarCastsHelper(personName: String?) {
        if (personName != null) {
            println("$TAG person name is $personName")
        } else {
            println("$TAG person name is $personName") //null
        }
    }

    //Kotlin Not-null assertion can produce Null pointer exceptions at runtime
    //when we used Not-null assertion(!!), it accepts a value and upon not finding
    //a value, it will throw a runtime exception which cannot be caught at compile-time
    //and will lead to a crash
    fun notNullAssertions() {
        var myName: String? = "Puneet"
        println("$TAG Using Not-null assertion, myName has a value ${myName!!}")
        myName = null
        //the statement below will throw an error, so commenting out
        //println("$TAG Using Not-null assertion, myName has a value ${myName!!}")
    }

    fun elvisOperator() {
        var nullableInt: Int? = 999
        var mustHaveResult = nullableInt ?: 100
        println("$TAG Using elvis operator, value is $mustHaveResult")

        nullableInt = null
        mustHaveResult = nullableInt ?: 100
        println("$TAG Using elvis operator, value is $mustHaveResult")
    }

    fun safeCalls() {

        val nullableString1: String? = null
        val nullableString2: String? = "Puneet Chugh"

        println("$TAG printing nullableString1 length ${nullableString1?.length}")
        println("$TAG printing nullableString2 length ${nullableString2?.length}")

        nullableString1?.let { println("$TAG printing length of nullableString1 ${nullableString1.length}") } //this won't print
        nullableString2?.let { println("$TAG printing length of nullableString2 ${nullableString2.length}") }

        val stringToPrint = nullableString1?.let { "printing length of string : ${it.length}" } ?: "string is null"

        println("$TAG $stringToPrint")
    }

    //Question - Create a function that returns the number of times an integer could be
    //divided by another integer without a remainder
    private fun divideIfWhole(value: Int, divisor: Int): Int? {
        var timesDivisible: Int? = null
        var remainder = 0
        println("$TAG Initial value before division (value,divisor) : ($value,$divisor), timesDivided : $timesDivisible")

        if (value > divisor) {
            remainder = value % divisor
            if (remainder == 0) {
                timesDivisible = value / divisor
            }
        }
        return timesDivisible
    }

    private fun divideIfWholeElvis(value: Int, divisor: Int): Int {
        var timesDivisible: Int? = null
        var remainder = 0
        println("$TAG Initial value before division (value,divisor) : ($value,$divisor), timesDivided : $timesDivisible")

        if (value > divisor) {
            remainder = value % divisor
            if (remainder == 0) {
                timesDivisible = value / divisor
            }
        }
        return timesDivisible ?: 0
    }

    fun checkDivideIfWholeSolution() {
        println("$TAG Checking if divisible whole with value,divisor = (10,2), ${divideIfWhole(10, 2) ?: "null"}")
        println("$TAG Checking if divisible whole with value,divisor = (10,3) ${divideIfWhole(10, 3)}")
        println("$TAG Checking if divisible whole with value,divisor = (30,3) ${divideIfWhole(30, 3)}")
        println("$TAG Checking if divisible whole with value,divisor = (2,5) ${divideIfWhole(2, 5)}")

        println("$TAG Solution 2: Checking if divisible whole with value,divisor = (10,2), ${divideIfWholeElvis(10, 2)}")
        println("$TAG Solution 2: Checking if divisible whole with value,divisor = (10,3) ${divideIfWholeElvis(10, 3)}")
        println("$TAG Solution 2: Checking if divisible whole with value,divisor = (30,3) ${divideIfWholeElvis(30, 3)}")
        println("$TAG Solution 2: Checking if divisible whole with value,divisor = (2,5) ${divideIfWholeElvis(2, 5)}")

    }

}