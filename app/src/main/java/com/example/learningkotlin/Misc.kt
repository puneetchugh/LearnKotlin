package com.example.learningkotlin

object Misc {

    val TAG = "${Misc::class.java}:"

    enum class ORDERS {
        ONE,
        TWO,
        THREE
    }

    enum class ENUMSWITHSTRINGS(val stringValue: String) {
        ONE("one"),
        TWO("two"),
        THREE("three");

        companion object {
            fun findByValue(stringValue: String): ENUMSWITHSTRINGS {
                for (item in values()) {
                    if (item.stringValue == stringValue) {
                        return item
                    }
                }
                return ONE
            }
        }
    }

    fun usingEnums() {
        val enumOne = ORDERS.ONE
        println("$TAG enumOne.name : ${enumOne.name}, enumOne : ${enumOne.ordinal}")

        val enumWithStringsOne = ENUMSWITHSTRINGS.findByValue("three")
        println("$TAG enumWithStringsOne.name : ${enumWithStringsOne.name}, enumWithStringsOne.ordinal : ${enumWithStringsOne.ordinal}, enumWithStringsOne.stringValue : ${enumWithStringsOne.stringValue}")
    }
}