package com.example.learningkotlin.sectionTwo

data class Person(val name: String, val age: Int)

object Chapter9 {
    val TAG = "${Chapter9::class.java}:"
    //maps, mutable maps
    //map - using index operator
    //

    fun maps() {
        val map: Map<String, Person>
        val person1 = Person("Puneet Chugh", 20)
        val person2 = Person("John Smith", 30)
        val person3 = Person("Larry Carpentar", 40)
        map = mapOf(
            person1.name to person1,
            person2.name to person2,
            person3.name to person3
        )
        println("$TAG map is ${map.toString()}")

        println("$TAG removing Person(\"Puneet Chugh\", 29) from map : ${map - person1.name}")

        println("$TAG Get value for ${person1.name} ${map[person1.name]}")
        println("$TAG Get value for ${person1.name} ${map.get(person1.name)}")

        val namesToNamesLength = map.map { it.key to it.value.name.length }.toMap().toSortedMap(compareBy<String> { it.length }.thenBy { it })
        println("$TAG new map: $namesToNamesLength")

        println("$TAG printing the keys of map ${map.keys}")
        println("$TAG printing the values of map ${map.values}")
        println("$TAG printing the entries of map ${map.entries}")
    }

    fun sets() {
        val set: Set<String> = setOf("Puneet", "Chugh", "Puneet", "Chugh")
        println("$TAG sets : ${set.joinToString()}")

        println("$TAG set after minus Puneet ${set - "Puneet"}")

        //filter vowels
        val vowelSet = "aeiou".toSet()
        val stringWithoutVowels = "My name is Puneet".filter { it !in vowelSet }
        println("$TAG strings without vowels : $stringWithoutVowels")
    }

    fun lists() {
        //toList() vs asList()

        //toList() keeps the same backing array
        val array1 = arrayOf("Puneet", "Chugh", "John", "King")
        val list = array1.asList()
        println("$TAG array1 ${array1.contentToString()}")
        println("$TAG array1.asList() ${list.joinToString()}}")
        array1[0] = "Kaku"
        println("$TAG array1.asList() ${list.joinToString()} after changing array[0]}")

        //asList() maintains a copy
        val array2 = arrayOf("Puneet", "Chugh", "John", "King")
        val list2 = array2.toList()
        println("$TAG array2 ${array2.contentToString()}")
        println("$TAG array2.toList() ${list2.joinToString()}}")
        array2[0] = "Kaku"
        println("$TAG array2.asList() ${list2.joinToString()} after changing array[0]}")

    }
}