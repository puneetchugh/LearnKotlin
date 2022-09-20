package com.example.learningkotlin.sectionThree.chapter12

class Student private constructor(
    val id: Int,
    val firstName: String,
    val lastName: String
) {


    companion object Factory {

        private var currentId = 0

        @JvmStatic
        fun newStudent(
            firstName: String,
            lastName: String
        ): Student {
            currentId += 1
            return Student(currentId, firstName, lastName)
        }
    }

    var fullName = "$firstName $lastName"
}