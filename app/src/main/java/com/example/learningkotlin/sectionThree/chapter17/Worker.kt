package com.example.learningkotlin.sectionThree.chapter17

class Worker(override val name: String, override val bonus: Int) : Employee {

    override val TAG: String
        get() = "${Worker::class.java}:"

    override val hourlyPay: Int
        get() = 25

    override fun salary(hours: Int): Int {
        return bonus + hours * hourlyPay
    }

    override fun compareTo(other: Employee): Int {
        return name.length - other.name.length
    }
}