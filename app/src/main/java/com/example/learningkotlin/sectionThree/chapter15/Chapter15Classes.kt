package com.example.learningkotlin.sectionThree.chapter15

import com.example.learningkotlin.sectionThree.chapter15.Constants.TAG


object Constants {
    const val TAG = "Chapter15"
}

/*--------------------------------------------------------------------------------*/
open class Person(private var firstName: String, private var lastName: String) {
    open fun fullName(): String {
        return "$firstName $lastName"
    }
}

class Student(firstName: String, lastName: String) : Person(firstName, lastName) {

    override fun fullName(): String {
        return "Student, ${super.fullName()}"
    }

    open fun justStudentThing(): String {
        return "Inside Student open fun"
    }
}
/*--------------------------------------------------------------------------------*/



/*--------------------------------------------------------------------------------*/
abstract class Vehicle(private val maxSpeed: Int) {

    abstract fun printName()
    fun vehicleSpeed() {
        println("$TAG Vehicle class vehicleSpeed(), $maxSpeed")
    }
}

abstract class MotorVehicle(maxSpeed: Int) : Vehicle(maxSpeed) {
    abstract val wheels: Int
}

class TwoWheeler(val vehicleName: String, maxSpeed: Int) : MotorVehicle(maxSpeed) {

    override val wheels: Int
        get() = 2

    override fun printName() {
        println("$TAG Inside TwoWheeler()->printName(), vehicle name is :$vehicleName")
    }

}

class FourWheeler(val vehicleName: String, maxSpeed: Int) : MotorVehicle(maxSpeed) {

    override val wheels: Int
        get() = 4

    override fun printName() {
        println("$TAG Inside FourWheeler()->printName(), vehicle name is :$vehicleName")
    }
}
/*----------------------------------------------------------------------------------*/

/*----------------------------------------------------------------------------------*/

class Machine(val machineName: String, val yearOfMake: Int) {
    fun printInfo() = println("$TAG Machine $machineName, year of make : $yearOfMake")
}

//Both ways are same
/*class Machine constructor(val machineName: String, val yearOfMake: Int){
    fun printInfo() = println("$TAG Machine $machineName, year of make : $yearOfMake")
}*/

/*----------------------------------------------------------------------------------*/

//Secondary constructor
/*----------------------------------------------------------------------------------*/

open class Shape {
    constructor(size: Int) {

    }

    constructor(size: Int, color: String) : this(size) {

    }
}

class Circle : Shape {
    constructor(size: Int) : super(size) {

    }

    constructor(size: Int, color: String) : super(size, color) {

    }
}
/*----------------------------------------------------------------------------------*/

//Inner class
/*----------------------------------------------------------------------------------*/
/*class Car(val carName: String) {
    class Engine(val engineName: String) {
        override fun toString(): String {
            return "$engineName in a $carName" // Error: cannot see carName in outer scope!
        }
    }
}*/

class Car(val carName: String) {
    inner class Engine(private val engineName: String) {
        override fun toString(): String {
            return "$engineName engine in a $carName"
        }
    }
}

/*----------------------------------------------------------------------------------*/


object Classes15Object {
    fun testingClasses() {

        val personPuneet = Person("Puneet", "Chugh")
        println("${Constants.TAG} Person Puneet : ${personPuneet.fullName()}")

        val studentPuneet = Student("Puneet", "Chugh")
        println("$TAG Student Puneet : ${studentPuneet.fullName()}")
        println("$TAG Student Puneet, calling open function, ${studentPuneet.justStudentThing()}")

        println("$TAG is studentPuneet a Person : ${studentPuneet is Person}")
        println("$TAG is personPuneet a Student : ${personPuneet is Student}")

        println("$TAG Casting studentPuneet as a Person and calling fullName ${(studentPuneet as Person).fullName()}")

        val myFourWheeler = FourWheeler("Audi A8", 150)
        println("$TAG myFourWheeler, ${myFourWheeler.vehicleName}")
        myFourWheeler.vehicleSpeed()
        myFourWheeler.printName()


        val mazda = Car("mazda")
        val mazdaEngine = mazda.Engine("rotary")
        println("$TAG $mazdaEngine") // > rotary engine in a mazda
    }
}