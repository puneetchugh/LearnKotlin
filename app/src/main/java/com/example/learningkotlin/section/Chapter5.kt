package com.example.learningkotlin.section

object Chapter5 {
    //ranges
    //increasing range
    // 0..5 inclusive
    //0 until 5 open range, end not inclusive
    //decreasing range
    //5 downTo 0 - inclusive
    //repeat loop repeat(20)
    //steps in loop
    //continue
    //label for loops
    //when with sealed classes, pattern matching,

    val TAG = "${Chapter5::class.java}:"

    fun increasingRanges() {
        val range0To10Inclusive = 0..10 //closed range
        val range0To10NonInclusive = 0 until 10 //half open range, i.e., 1 less than the end

        range0To10Inclusive.forEach { number -> println("Iterating over $number") }
        range0To10NonInclusive.forEachIndexed { index, value -> println("Iterating over index $index and value $value") }

        println("$TAG Printing the highest value of the range closed range 0-10 : ${range0To10Inclusive.maxOrNull()}")
        println("$TAG Printing the highest value of the half open range 0-10 :${range0To10NonInclusive.maxOrNull()}")

        println("$TAG Printing the lowest value of the range closed range 0-10 : ${range0To10Inclusive.minOrNull()}")
        println("$TAG Printing the lowest value of the half open range 0-10 :${range0To10NonInclusive.minOrNull()}")
    }

    fun decreasingRanges() {

        val range10To0 = 10 downTo 0 //all inclusive

        range10To0.forEach {
            println("$TAG Decreasing range: Iterating over $it")
        }
        println("$TAG Decreasing range 10-0, maxOrNull(): ${range10To0.maxOrNull()} ")
        println("$TAG Decreasing range 10-0, minOrNull(): ${range10To0.minOrNull()} ")
        println("$TAG Decreasing Range 10-0, firstOrNull(): ${range10To0.firstOrNull()}")
    }

    fun forLoops() {
        for (counter in 0..10) {
            println("$TAG : Iterating over $counter")
        }

        //steps in loops
        for (counter in 0..10 step 2) { //This will only iterate over even numbers
            println("$TAG : Iterating over range with step of 2: $counter")
        }

        for (counter in 10 downTo 0 step 2) {
            println("$TAG : Iterating over decreasing range with step size of 2: $counter")
        }
    }

    fun repeatForLoops(number: Int) {
        var sum = 0
        var localNumber = number
        repeat(number) {
            sum += localNumber
            println("$TAG Sum after each iteration $sum, localNumber : $localNumber")
            localNumber += 1
        }
    }

    fun labels() {
        val squareSize = 4
        val stringBuilder = StringBuilder()
        rowLoop@ for (row in 0..squareSize) {
            var productOfRowAndCol: Int
            columnLoop@ for (col in 0..squareSize) {
                if (row == col) {
                    stringBuilder.append("\n")
                    continue@rowLoop
                }
                productOfRowAndCol = row * col
                println("Iterating over ($row, $col), sum $productOfRowAndCol")
                stringBuilder.append("$productOfRowAndCol\t")
            }
        }
        println("$TAG printing the array $stringBuilder")
    }

    fun whenInKotlin() {

        val number = 10
        when (number) {
            0 -> println("Zero")
            else -> println("Non-Zero")
        }

        val stringValue = "Puneet"
        when (stringValue) {
            "Puneet" -> println("Puneet exists")
            "Chugh" -> println("Chugh exists")
        }

        val timeOfTheDay: String
        val hourOfTheDay = 12
        timeOfTheDay = when (hourOfTheDay) {
            in 0..5 -> "Early monring"
            in 6..11 -> "Morning"
            in 12..16 -> "Afternoon"
            in 17..19 -> "Evening"
            in 20..23 -> "Late evening"
            else -> "Invalid hour"
        }
        println("$TAG timeOfTheDay: $timeOfTheDay")

        val arrayOfStrings = arrayOf("PuneetChugh", "PuneetMalhotra", "MatthewWade", "MatthewSymonds", "MarkWaugh", "MikeCharles", "CharliePuth")

        for (string in arrayOfStrings) {
            val stringToPrint =
                when {
                    string.startsWith("puneet", true) -> "First name is Puneet"
                    string.startsWith("matthew", true) -> "First name is Matthew"
                    else -> {
                        "First name is not Puneet or Matthew"
                    }
                }
            println("$TAG printing string: $stringToPrint")

            //also and let can be used to print the return value from when
            /*when {
                string.startsWith("puneet", true) -> "First name is Puneet"
                string.startsWith("matthew", true) -> "First name is Matthew"
                else -> {
                    "First name is not Puneet or Matthew"
                }
            }?.also { println("$TAG using 'also' printing string : $it") }*/

            val arrayOfNumbers = arrayOf(100, 90, 80, 45)

            arrayOfNumbers.forEach { number ->
                when {
                    number % 5 == 0 && number % 3 == 0 -> println("$TAG number $number is divisible by 15")
                    else -> println("$TAG number $number isn't divisible by 15")
                }
            }

        }
    }

    fun sealedClassesWithWhen() {
        val myPost1 = Post.Status("Sealed classes vs enums")
        val myPost2 = Post.Image(url = "https://something.com", caption = "This is an image status")
        val myPost3 = Post.Video(url = "https://something.com", encoding = "encoding", timeDuration = 110)

        val arrayOfPost = arrayOf(myPost1, myPost2, myPost3)
        arrayOfPost.forEach { post ->
            when (post) {
                is Post.Status -> println("It's a Status post with text : ${post.text}")
                is Post.Image -> println("It's an Image post")
                is Post.Video -> println("It's a Video post")
            }
        }
    }

}