package com.example.learningkotlin.sectionOne

object Chapter3 {

    var integer: Int = 1001
    var decimal: Double = 20.8

    private val TAG = "${Chapter3::class.java}:"

    fun typeConversion() {

        println("$TAG integer : $integer")
        println("$TAG decimal : $decimal")

        //implicit conversion of decimal to integer is not allowed in Kotin as there could be a loss of
        //precision for the decimal points
        //integer = decimal - not allowed

        //convert explicitly
        decimal = integer.toDouble()
        println("$TAG decimal value after  \"decimal = integer.toDouble()\" : $decimal")

        //decimal = 10 - not allowed. 10 is an integer, 10.0 is allowed
        decimal = 10.0
        decimal = 10.toDouble()

        integer = decimal.toInt() //explicit conversion is allowed

        //multiplying a mix of different types will not remove the precision
        decimal = 30.5
        integer = 3

        println("$TAG multiplication of $decimal and $integer : ${decimal * integer}")

        //Implicit type - inferred type, check Control + Shift + P
        val implicitInt = 100
    }

    fun kotlinStrings() {
        val stringTemplate = "The value of integer is $integer"
        println("$TAG stringTemplate $stringTemplate")

        val multipLineString = """
             |My
            |name
             |is 
            |Puneet
        """.trimMargin()
        println("$TAG multipLineString: $multipLineString")
        println(multipLineString)
    }

    fun kotlinStringsOperations() {
        val listOfStrings = listOf("Puneet Chugh", "Puneet is my name", "My name is Puneet", "Chugh", "Chugh is my last name")
        //any string starting with Puneet
        val filteredList1 = listOfStrings.filter { string -> string.startsWith("Puneet") }
        //any string that contains Puneet
        val filteredList2 = listOfStrings.filter { string -> string.contains("Puneet") }
        //any string that starts with Chugh
        val filteredList3 = listOfStrings.filter { string -> string.startsWith("Chugh") }
        //any string that has an even index
        val filteredList4 = listOfStrings.filterIndexed { index, _ -> index % 2 == 0 }
        println("$TAG Original list")
        listOfStrings.forEach { println("$TAG $it") }
        println("$TAG Filtered list 1 ")
        filteredList1.forEach { println("$TAG $it") }
        println("$TAG Filtered list 2 ")
        filteredList2.forEach { println("$TAG $it") }
        println("$TAG Filtered list 3 ")
        filteredList3.forEach { println("$TAG $it") }


        val localString = "puneet Chugh"
        for (char in localString) {
            println("$TAG $char is a vowel : ${char.isVowel()}")
        }
        println("$TAG Original string $localString")
        println("$TAG  Original string after .uppercase() : ${localString.uppercase()}")
        println("$TAG  Original string after .lowercase() : ${localString.lowercase()}")
        println("$TAG  Original string after capitalize : ${localString.replaceFirstChar { firstChar -> firstChar.uppercase() }}")

        for (index in localString.indices) {
            println("$TAG printing character $index of string ${localString[index]}")
        }
    }

    //extension function on Char to find out if the character is a vowel or not
    private fun Char.isVowel(): Boolean {
        //return this == 'a' || this == 'e' || this == 'i' || this == 'o' || this == 'u'
        return "aeiou".contains(this)
    }


    fun pairsAndTriplets(){
        val pairOne = Pair("Puneet", "Chugh")
        val pairTwo = Pair("Tom", "Moody")
        val pairThree = Pair("Steve", "Waugh")
        val pairFour = "Ben" to "Stokes"

        val listOfPairs = mutableListOf<Pair<String,String>>()
        listOfPairs.add(pairOne)
        listOfPairs.add(pairTwo)
        listOfPairs.add(pairThree)
        listOfPairs.add(pairFour)

        //print only the first name of all people in the list
        listOfPairs.forEachIndexed() { _, pair-> println("$TAG First name : ${pair.first}") }

        val triplet = Triple("Puneet", "Chugh", "Aug")
        println("$TAG value of triplet (${triplet.first}, ${triplet.second}, ${triplet.third})")

        val (firstName, secondName, birthMonth) = triplet
        println("$TAG Triplet ($firstName, $secondName, $birthMonth)")
    }

}