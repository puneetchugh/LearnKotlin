package com.example.learningkotlin.sectionFour

class Chapter20 {

    val TAG: String by lazy { "${Chapter20::class.java}:" }

    //Exceptions,
    //Throwable -> Exceptions, Error
    //multiple catch blocks - from most specific to general
    //finally block
    //Custom exceptions
    //Java and Kotlin exceptions
    //try as an expression
    //@Throws(IOException::class)
    //elvis operator can throw


    fun catchingAnException() {
        val number = 10.39
        val string = "Puneet"
        try {
            val numberToInt = number.toInt()
            val stringToInt = string.toInt()
        } catch (nfe: NumberFormatException) {
            println("$TAG NumberFormatException : ${nfe.message}")
        } catch (exception: Exception) {
            println("$TAG Exception : ${exception.message}")
        } finally {
            println("$TAG finally always prints irrespective of any of the catch blocks executing or not")
        }
    }

    fun tryCatchAsAnExpression() {
        val number = try {
            val message = "Inside tryCatchAsAnExpression() method"
            message.toInt()
        } catch (exception: NumberFormatException) {
            println("$TAG NumberFormatException : ${exception.message}")

        }
    }

    fun callingFunThrowsExceptionMethod() {
        try {
            funThrowsException(12)
        } catch (illegalArgException: java.lang.IllegalArgumentException) {
            println("$TAG It's an IllegalArgumentException : ${illegalArgException.message}")
        } catch (customException: CustomExceptionOver5) {
            println("$TAG It's an CustomExceptionOver5 : ${customException.message}")

        } finally {
            println("$TAG Inside callingFunThrowsExceptionMethod(), finally always executes")
        }
    }

    @Throws(IllegalArgumentException::class, IllegalStateException::class, CustomExceptionOver5::class)
    private fun funThrowsException(input: Int) {
        if (input > 5)
            throw CustomExceptionOver5("input cannot be more than 5")
    }

    fun callingUsingElvisOperatorMethod() {
        try {
            usingElvisOperator(null)
        } catch (illegalArgException: java.lang.IllegalArgumentException) {
            println("$TAG Inside callingFunThrowsExceptionMethod(), It's an IllegalArgumentException : ${illegalArgException.message}")
        } finally {
            println("$TAG Inside callingFunThrowsExceptionMethod(), finally always executes")
        }
    }

    @Throws(java.lang.IllegalArgumentException::class)
    private fun usingElvisOperator(input: String?): Int {
        return input?.toInt() ?: throw IllegalArgumentException("Inside usingElvisOperator(), input string is empty...")
    }

}