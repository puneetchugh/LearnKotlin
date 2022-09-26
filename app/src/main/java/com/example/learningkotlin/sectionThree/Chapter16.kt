package com.example.learningkotlin.sectionThree

object Chapter16 {

    val TAG = "${Chapter16::class.java}:"

    enum class MonthOfTheYear {
        JANUARY,
        FEBRUARY,
        MARCH,
        APRIL,
        MAY,
        JUNE,
        JULY,
        AUGUST,
        SEPTEMBER,
        OCTOBER,
        NOVEMBER,
        DECEMBER
    }

    enum class DayOfWeek(val dayString: String) {
        Sunday("sunday"),
        Monday("monday"),
        Tuesday("tuesday"),
        Wednesday("wednesday"),
        Thursday("thursday"),
        Friday("friday"),
        Saturday("saturday");

        companion object {
            fun mapByTheDayString(dayString: String): DayOfWeek {
                return values().find { it.dayString == dayString } ?: Sunday
            }
        }
    }

    enum class DayOfWeekWithExtras(val dayString: String, val index: Int) {
        Sunday("sunday", 100),
        Monday("monday", 101),
        Tuesday("tuesday", 102),
        Wednesday("wednesday", 103),
        Thursday("thursday", 104),
        Friday("friday", 105),
        Saturday("saturday", 106);

        companion object {
            fun mapByTheDayString(dayString: String): DayOfWeekWithExtras {
                return values().find { it.dayString == dayString } ?: Sunday
            }
        }
    }

    enum class DayOfWeekWithBoolean(val isWeekend: Boolean = false) {
        Sunday(true),
        Monday,
        Tuesday,
        Wednesday,
        Thursday,
        Friday,
        Saturday(true);

    }

    fun enums() {
        val dayOfWeek = DayOfWeek.mapByTheDayString("friday")
        println("$TAG printing dayOfWeek: $dayOfWeek")
        println("$TAG printing dayOfWeek: ${DayOfWeek.values().contentToString()}")

        for (month in MonthOfTheYear.values()) {
            println("$TAG ${month.ordinal}: ${month.name}")
        }

        val monthIndex = 7
        val monthOfTheYear = MonthOfTheYear.values()[monthIndex]
        println("$TAG printing monthOfTheYear, index 7: $monthOfTheYear")

        //This one's error
        //val month = MonthOfTheYear.valueOf("SOMETHING_THAT_DOESNT_EXIST")
        val month = MonthOfTheYear.valueOf("MARCH")
        println("$TAG printing month: $month")

        val dayOfWeekWithExtras = DayOfWeekWithExtras.mapByTheDayString("friday")
        println("$TAG printing dayOfWeekWithExtras: $dayOfWeekWithExtras, ordinal value : ${dayOfWeekWithExtras.ordinal}, index : ${dayOfWeekWithExtras.index}")
        println("$TAG printing dayOfWeekWithExtras: ${DayOfWeekWithExtras.values().contentToString()}")

        DayOfWeekWithBoolean.values().forEach {
            println("$TAG printing DayOfWeekWithBoolean: $it, DayOfWeekWithBoolean.isWeekend: ${it.isWeekend}")
        }
    }


    sealed class AcceptedCurrency {
        abstract val valueInDollars: Float

        class Dollar : AcceptedCurrency() {
            override val valueInDollars = 1.0f
        }

        class Euro : AcceptedCurrency() {
            override val valueInDollars = 1.25f
        }

        class Crypto : AcceptedCurrency() {
            override val valueInDollars = 2534.92f
        }
    }

    fun usingSealedClasses() {

        val arrayOfAcceptedCurrencies = arrayOf(AcceptedCurrency.Dollar(), AcceptedCurrency.Euro(), AcceptedCurrency.Crypto())
        arrayOfAcceptedCurrencies.forEach { acceptedCurrency ->
            when (acceptedCurrency) {
                is AcceptedCurrency.Crypto -> println("$TAG, It's a Crypto, value In dollars : ${acceptedCurrency.valueInDollars}")
                is AcceptedCurrency.Dollar -> println("$TAG, It's a Dollar, value In dollars : ${acceptedCurrency.valueInDollars}")
                is AcceptedCurrency.Euro -> println("$TAG, It's a Euro, value In dollars : ${acceptedCurrency.valueInDollars}")
            }
        }
    }
}