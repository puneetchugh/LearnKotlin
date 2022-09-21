package com.example.learningkotlin.sectionThree.chapter17

interface Employee : Comparable<Employee> {

    val TAG: String

    val name: String
    val bonus: Int
    val hourlyPay: Int
    fun salary(hours: Int = 40): Int

    fun printEmployeeInfo() {
        println("$TAG name: $name")
    }
}