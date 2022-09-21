package com.example.learningkotlin.sectionThree.chapter17

class Manager(override val name: String, override val bonus: Int) : Employee {

    override val TAG: String
        get() = "${Manager::class.java}:"
    override val hourlyPay: Int
        get() = 50

    override fun salary(hours: Int): Int {
        return bonus + hours * hourlyPay
    }

    override fun printEmployeeInfo() {
        super.printEmployeeInfo()
        println("$TAG ")
    }

    override fun compareTo(other: Employee): Int {
        return name.length - other.name.length
    }
}