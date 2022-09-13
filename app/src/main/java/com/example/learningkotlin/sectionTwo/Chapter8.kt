package com.example.learningkotlin.sectionTwo

object Chapter8 {
    //Arrays - Boxed type and primitive type
    //iterating
    //List - linkedlist arraylist
    //slice(), first(), minOrNull(), maxOrNull(), remove, in, operator +, joinToString(), indexOf()
    //withIndex()
    //nullable list vs List with Nullable items

    val TAG = "${Chapter8::class.java}:"

    //all these array declarations/initializations will lead to Array<T>, boxed values array
    fun arrays() {
        //array of size 5 with initial value of 8
        val fiveEights = Array(5) { 8 }
        println("$TAG ${fiveEights.contentToString()}")

        val array = arrayOf(1, 2, 3, 4, 5)
        println("$TAG ${array.contentToString()}")

        //array values will be index values
        val indexValues = Array(5) { it }
        println("$TAG ${indexValues.contentToString()}")

        //array values will be index + 1
        val indexValuePlusOne = Array(5) { it + 1 }
        println("$TAG ${indexValuePlusOne.contentToString()}")

        //Trying to initialize empty array without type doesn't work
        //It needs a type, this is an error
        //val emptyArray = arrayOf()

        //Initialize empty array
        val emptyArray1: Array<Int> = arrayOf()
        val emptyArray2 = arrayOf<Int>()
        val emptyArray3 = emptyArray<Int>()
        println("$TAG empty array ${emptyArray3.contentToString()}")

        val arrayOfNulls = arrayOfNulls<Int>(5)
        println("$TAG array of nulls ${arrayOfNulls.contentToString()}")

        val vowels = arrayOf('a', 'e', 'i', 'o', 'u')
        val vowels1 = "aeiou".toCharArray() //produces CharArray (primitive)
        println("$TAG array of vowels ${vowels1.contentToString()}")
    }

    fun primitiveArrays() {

        val intArr = intArrayOf(100, 200, 300)
        val intArr1 = arrayOf(1, 3, 5, 7).toIntArray()
        println("$TAG ints ${intArr1.contentToString()}")


        val doubleArr = DoubleArray(5) { 10.5 }
        println("$TAG doubles ${doubleArr.contentToString()}")
    }

    //list creates collection of objects (there's no way to create primitives in lists)
    //
    fun lists() {

        val team = listOf("Puneet", "John", "Chris", "Jack")
        println("$TAG team ${team.joinToString()}")

        val team1 = arrayListOf("Puneet", "John", "Chris", "Jack")
        println("$TAG team ${team1.joinToString()}")

        val emptyList1 = emptyList<String>()
        val emptyList2: List<String> = listOf()
        val emptyList3 = listOf<String>()
    }

    fun mutableLists() {
        val mutableListOfPlayers = mutableListOf<String?>()
        mutableListOfPlayers.add("Puneet Chugh")
        //mutableListOfPlayers.add(4, "John Smith") - throws IndexOutOfBoundException
        //mutableListOfPlayers.set(3, "Stephan Singh") - throws IndexOutOfBoundException
        //mutableListOfPlayers[6] = "Allen King" //- throws IndexOutOfBoundException
        mutableListOfPlayers.addAll(arrayOf("John Smith", null, "Stephan King"))
        println("$TAG mutable list of players ${mutableListOfPlayers.joinToString(",")}")

        val mutableListOfNames: MutableList<String> = MutableList(10) { "" }
        println("$TAG mutable list of names empty ${mutableListOfNames.joinToString(",")}")
        //mutableListOfPlayers.add(4, "John Smith") - throws IndexOutOfBoundException
        // mutableListOfPlayers.set(3, "Stephan Singh") - throws IndexOutOfBoundException
        //mutableListOfPlayers[6] = "Allen King" //- throws IndexOutOfBoundException
        mutableListOfNames.add(4, "John Smith")
        mutableListOfNames.set(3, "Stephan Singh")
        mutableListOfNames[6] = "Allen King"
        println("$TAG mutable list of names after filling ${mutableListOfNames.joinToString(",")}")
    }

    fun iterating() {
        val names = listOf("Puneet Chugh", "John Smith", "Michelle Zhang")

        println("$TAG Printing names")
        for (name in names) {
            println("$TAG name")
        }

        println("$TAG Printing name and indices")
        for ((index, name) in names.withIndex()) {
            println("$TAG {$index, $name}")
        }

        println("$TAG Printing only indices")
        for (index in names.indices) {
            println("$TAG $index")
        }

        println("$TAG Printing names using forEach")
        names.forEach { name ->
            println("$TAG $name")
        }

        println("$TAG Printing names using forEachIndexed")
        names.forEachIndexed { index, name ->
            println("$TAG {$index, $name}")
        }

        val funAsParam = { name: String ->
            println("$TAG $name")
        }

        println("$TAG Printing names using function as parameter")
        names.forEach(funAsParam)
        names.forEach(::printName)
    }

    private fun printName(name: String) {
        println("$TAG $name")
    }

    fun listMethods() {

        println("$TAG Inside listMethods()")
        val list = mutableListOf(null, "Puneet")
        list += "Gina"
        list += "Frank"
        list -= "Bob" //not an error, if element doesn't exists will not remove
        println("$TAG printing list ${list.joinToString()}")
        list.removeAt(1)
        println("$TAG printing list after removing element at index 1 ${list.joinToString()}")
        println("$TAG trying to remove Gina from the list, removed ? ${list.remove("Gina")}")

        println("$TAG first ${list.first()}")
        println("$TAG firstOrNull ${list.firstOrNull()}")


        val emptyList = mutableListOf<String>()
        //println("$TAG first ${emptyList.first()}") - gives error since list is empty
        println("$TAG firstOrNull ${emptyList.firstOrNull()}")

        val names = listOf("Puneet Chugh", "Mike Stallion", "Yong Song", "Zak Alfredo", "Grace Steward")
        println("$TAG firstOrNull ${names.firstOrNull()}") //first()
        println("$TAG minOrNull ${names.minOrNull()}") //min()
        println("$TAG maxOrNull ${names.maxOrNull()}") //max()


        //slice creates a new list for the index range
        names.slice(1..3).forEach { name ->
            println("$TAG iterating through sliced list name $name")
        }

        println("$TAG name Puneet Chugh exists in the list ${namesExists("Puneet Chugh", names)}")

        //sublist only presents a view of the range of index
        names.subList(1, 3).forEach {
            println("$TAG Iterating through the sublist name $it")
        }

        println("$TAG index of \"Zak Alfredo\" in names ${names.indexOf("Zak Alfredo")}")

        println("$TAG list before reversing ${names.joinToString()}}")
        println("$TAG list after reversing ${reverseList(names)}")
    }

    private fun namesExists(name: String, list: List<String>): Boolean {
        return name !in list
    }

    private fun reverseList(names: List<String>): List<String> {
        val tempList = mutableListOf<String>()
        for (index in names.lastIndex downTo 0) {
            tempList.add(names[index])
        }

        //also reverses the list
        /*for(index in names.indices.reversed()){
            tempList.add(names[index])
        }*/

        return tempList.toList()
    }
}