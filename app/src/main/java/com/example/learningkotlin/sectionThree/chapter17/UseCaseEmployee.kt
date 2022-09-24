package com.example.learningkotlin.sectionThree.chapter17


object UserCaseEmployee {

    val TAG = "${UserCaseEmployee::class.java}:"

    fun createUser() {
        val johnny: Manager = Manager("Johnny", 1000)
        val johnCompensation: Compensation = Compensation(johnny, 30)
        println("$TAG ${johnny.name}, salary:${johnCompensation.salary}")

        val tina: Manager = Manager("Tina", 5000)
        val tinaCompensation: Compensation = Compensation(tina, 50)
        println("$TAG ${tina.name}, salary:${tinaCompensation.salary}")

        println("$TAG Comparing Johnny and Tina, is johnny bigger than tina ${johnny > tina}")
    }
}