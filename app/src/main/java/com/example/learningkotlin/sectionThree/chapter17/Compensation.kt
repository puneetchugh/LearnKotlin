package com.example.learningkotlin.sectionThree.chapter17

class Compensation(private val employee: Employee, private val hours: Int) {
    val salary: Int
        get() = employee.salary(hours)
}