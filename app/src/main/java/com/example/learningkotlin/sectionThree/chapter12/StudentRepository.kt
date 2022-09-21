package com.example.learningkotlin.sectionThree.chapter12

object StudentRepository {

    const val COMPILE_TIME_CONSTANT_1 = "compile_time_constant_1"
    const val COMPILE_TIME_CONSTANT_2 = "compile_time_constant_2"

    val TAG = "${StudentRepository::class.java}:"
    val allStudents = mutableListOf<Student>()

    fun addStudent(student: Student, counter: Counter) {
        allStudents.add(student)
        counter.studentCount()
    }

    fun removeStudent(student: Student) {
        allStudents.remove(student)
    }

    fun listAllStudent() {
        allStudents.forEach {
            println("$TAG Student ${it.id}: ${it.fullName}")
        }
    }
}