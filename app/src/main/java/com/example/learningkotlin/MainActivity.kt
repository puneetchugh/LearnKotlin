package com.example.learningkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.learningkotlin.Misc.usingEnums
import com.example.learningkotlin.sectionFour.Chapter20
import com.example.learningkotlin.sectionOne.Chapter2
import com.example.learningkotlin.sectionOne.Chapter3.kotlinStrings
import com.example.learningkotlin.sectionOne.Chapter3.kotlinStringsOperations
import com.example.learningkotlin.sectionOne.Chapter3.pairsAndTriplets
import com.example.learningkotlin.sectionOne.Chapter3.typeConversion
import com.example.learningkotlin.sectionOne.Chapter4.createTrie
import com.example.learningkotlin.sectionOne.Chapter4.ifElseExpression
import com.example.learningkotlin.sectionOne.Chapter4.loops
import com.example.learningkotlin.sectionOne.Chapter4.shortCircuit
import com.example.learningkotlin.sectionOne.Chapter5.decreasingRanges
import com.example.learningkotlin.sectionOne.Chapter5.forLoops
import com.example.learningkotlin.sectionOne.Chapter5.increasingRanges
import com.example.learningkotlin.sectionOne.Chapter5.labels
import com.example.learningkotlin.sectionOne.Chapter5.repeatForLoops
import com.example.learningkotlin.sectionOne.Chapter5.sealedClassesWithWhen
import com.example.learningkotlin.sectionOne.Chapter5.whenInKotlin
import com.example.learningkotlin.sectionOne.Chapter6.createBST
import com.example.learningkotlin.sectionOne.Chapter7.checkDivideIfWholeSolution
import com.example.learningkotlin.sectionOne.Chapter7.elvisOperator
import com.example.learningkotlin.sectionOne.Chapter7.kotlinNullable
import com.example.learningkotlin.sectionOne.Chapter7.kotlinSmartCasts
import com.example.learningkotlin.sectionOne.Chapter7.notNullAssertions
import com.example.learningkotlin.sectionOne.Chapter7.safeCalls
import com.example.learningkotlin.sectionThree.Chapter16.enums
import com.example.learningkotlin.sectionThree.Chapter16.usingSealedClasses
import com.example.learningkotlin.sectionThree.chapter11.Chapter11
import com.example.learningkotlin.sectionThree.chapter11.Chapter11.Companion.createClassInstance
import com.example.learningkotlin.sectionThree.chapter11.Chapter11Data
import com.example.learningkotlin.sectionThree.chapter11.challenge.MovieList
import com.example.learningkotlin.sectionThree.chapter11.challenge.User
import com.example.learningkotlin.sectionThree.chapter12.Counter
import com.example.learningkotlin.sectionThree.chapter12.Student
import com.example.learningkotlin.sectionThree.chapter12.StudentRepository
import com.example.learningkotlin.sectionThree.chapter13.Chapter13
import com.example.learningkotlin.sectionThree.chapter13.Chapter13CustomGetter
import com.example.learningkotlin.sectionThree.chapter13.Chapter13DelegatedProperties
import com.example.learningkotlin.sectionThree.chapter13.extensionProp
import com.example.learningkotlin.sectionThree.chapter15.Classes15Object.testingClasses
import com.example.learningkotlin.sectionThree.chapter17.UserCaseEmployee.createUser
import com.example.learningkotlin.sectionTwo.Chapter10.lambdaAndEnclosingScope
import com.example.learningkotlin.sectionTwo.Chapter10.lambdaOperations
import com.example.learningkotlin.sectionTwo.Chapter10.lambdas
import com.example.learningkotlin.sectionTwo.Chapter10.question
import com.example.learningkotlin.sectionTwo.Chapter10.sorting
import com.example.learningkotlin.sectionTwo.Chapter8.arrays
import com.example.learningkotlin.sectionTwo.Chapter8.iterating
import com.example.learningkotlin.sectionTwo.Chapter8.listMethods
import com.example.learningkotlin.sectionTwo.Chapter8.lists
import com.example.learningkotlin.sectionTwo.Chapter8.mutableLists
import com.example.learningkotlin.sectionTwo.Chapter8.primitiveArrays
import com.example.learningkotlin.sectionTwo.Chapter9
import com.example.learningkotlin.sectionTwo.Chapter9.maps
import com.example.learningkotlin.sectionTwo.Chapter9.sets

class MainActivity : AppCompatActivity() {

    val TAG = "${MainActivity::class.java}:"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chapter2()
        chapter3()
        chapter4()
        chapter5()
        chapter6()
        chapter7()
        chapter8()
        chapter9()
        chapter10()
        chapter11()
        chapter12()
        chapter13()
        chapter15()
        chapter16()
        chapter17()
        chapter20()
        misc()
    }

    private fun chapter2() {
        Chapter2.shiftLeft(4, 2)
        Chapter2.shiftLeft(2, 3)
        Chapter2.shiftLeft(5, 4)

        Chapter2.shiftRight(4, 1)
        Chapter2.shiftRight(3, 3)
        Chapter2.shiftRight(6, 2)

        Chapter2.mathFunctions()
        Chapter2.variablesAndConstants()
        Chapter2.solution()

    }

    private fun chapter3() {
        typeConversion()
        kotlinStrings()
        kotlinStringsOperations()
        pairsAndTriplets()
    }

    private fun chapter5() {
        increasingRanges()
        decreasingRanges()
        forLoops()
        labels()
        whenInKotlin()
        sealedClassesWithWhen()
        repeatForLoops(6)
    }

    private fun chapter7() {
        kotlinNullable()
        kotlinSmartCasts()
        notNullAssertions()
        elvisOperator()
        checkDivideIfWholeSolution()
        safeCalls()
    }

    private fun chapter6() {
        createBST()
    }

    private fun chapter4() {
        createTrie()
        loops()
        ifElseExpression()
        shortCircuit()
    }

    private fun chapter8() {
        arrays()
        primitiveArrays()
        lists()
        mutableLists()
        iterating()
        listMethods()
    }

    private fun chapter9() {
        maps()
        sets()
        Chapter9.lists()
    }

    private fun chapter10() {
        lambdas()
        lambdaAndEnclosingScope()
        sorting()
        lambdaOperations()
        question()
    }

    private fun misc() {
        usingEnums()
    }

    private fun chapter13() {
        val chapter12CustomGetter = Chapter13CustomGetter(50.50, 40.50)
        println("$TAG${Chapter13CustomGetter.TAG} diagonal value computed is ${chapter12CustomGetter.diagonal}")
        println("$TAG${Chapter13CustomGetter.TAG} diagonal value computed without height and width change is ${chapter12CustomGetter.diagonal}")

        chapter12CustomGetter.height = 100.50
        chapter12CustomGetter.width = 50.50
        println("$TAG${Chapter13CustomGetter.TAG} diagonal value computed after height and width are updated is ${chapter12CustomGetter.diagonal}")

        val chapter12DelegatedProperties = Chapter13DelegatedProperties(15)
        println("$TAG${Chapter13DelegatedProperties} initial value of unlocked ${chapter12DelegatedProperties.unlocked}, highestLevel ${chapter12DelegatedProperties.highestLevel}, unlockedDelegateVetoable ${chapter12DelegatedProperties.unlockedDelegateVetoable}")
        chapter12DelegatedProperties.unlocked = true
        println("$TAG${Chapter13DelegatedProperties} after value of unlocked changed, unlocked ${chapter12DelegatedProperties.unlocked}, highestLevel ${chapter12DelegatedProperties.highestLevel}, unlockedDelegateVetoable ${chapter12DelegatedProperties.unlockedDelegateVetoable}")
        chapter12DelegatedProperties.unlockedDelegateVetoable = 25
        println("$TAG${Chapter13DelegatedProperties} after value of unlockedDelegateVetoable, unlocked ${chapter12DelegatedProperties.unlocked}, highestLevel ${chapter12DelegatedProperties.highestLevel}, unlockedDelegateVetoable ${chapter12DelegatedProperties.unlockedDelegateVetoable}")
        chapter12DelegatedProperties.printing()

        val chapter12 = Chapter13(10, 30)
        println("$TAG${Chapter13.TAG} printing the extension property : ${chapter12.extensionProp}")
    }

    private fun chapter11() {
        var newChapter = createClassInstance("Chapter50", "Section10")
        newChapter = createClassInstance("Chapter25", "Section5")
        newChapter.chapterName = "Chapter30"
        println("$TAG:${Chapter11.TAG} New Chapter is updated : ${newChapter.description}")

        val newChapterStart = createClassInstance("Chapter0", "Section0")
        val newChapterEnd = createClassInstance("Chapter0", "Section0")

        //This values equality will still give false as the class doesn't have equals and hashCode overriden,
        //The Class is not a data class
        println("$TAG:${Chapter11.TAG} Checking the equality == operator for values of $newChapterStart and $newChapterEnd ${newChapterStart == newChapterEnd}")
        println("$TAG:${Chapter11.TAG} Checking the reference equality === operator for $newChapterStart and $newChapterEnd ${newChapterStart === newChapterEnd}")

        val listOfChapters = listOf(
            createClassInstance("Chapter0", "Section0"),
            createClassInstance("Chapter1", "Section1"),
            createClassInstance("Chapter50", "Section10"),
            newChapterStart
        )

        //List<>.contains() works on the value equality == operator, but if hashCode() and equals() aren't overriden, then equality (==) then default reference equality will be used
        //if the Class is converted to 'data class', then hashCode() and equals() will be overriden too and hence it will be truly values comparison
        println("$TAG${Chapter11.TAG} Checking if list of Chapters contain newChapterEnd ${listOfChapters.contains(newChapterEnd)}")
        println("$TAG${Chapter11.TAG} Checking if list of Chapters contain newChapterStart ${listOfChapters.contains(newChapterStart)}")

        //destructuring syntax - data class, the params mentioned in constructor
        val newChapterData = Chapter11Data("Chapter11", "Section3")
        val (chapterName, section) = newChapterData
        println("$TAG${Chapter11::class.java} Destructuring newChapterData ($chapterName, $section) ")


        //challenge in Chapter 11
        val userPuneet = User("Puneet")
        val movieList = MovieList.createMovieListInstance(listOf("The Pursuit Of Happiness", "Chandlier's list"))
        userPuneet.addList(movieList)
        println("$TAG${User.TAG} User Puneet's list : ${userPuneet.list()}")

        val userJohn = User("John")
        val movieListJohn = MovieList.createMovieListInstance(listOf("Jurassic Park", "Titanic"))
        userJohn.addList(movieListJohn)
        println("$TAG${User.TAG} User John's list : ${userJohn.list()}")

        val userGodu = User("Godu")
        //val movieListGodu = MovieList.createMovieListInstance(listOf("Narnia", "Alabama"))
        //userGodu.addList(movieListGodu)
        println("$TAG${User.TAG} User Godu's list : ${userGodu.list()}")
    }

    private fun chapter12() {
        val student1 = Student.newStudent("Puneet", "Chugh")
        val student2 = Student.newStudent("Chris", "Carpentar")
        val student3 = Student.newStudent("Frank", "Yeats")


        val counter = object : Counter {
            override fun studentCount(): Int {
                println("$TAG${StudentRepository.TAG} Students count: ${StudentRepository.allStudents.size}")
                return StudentRepository.allStudents.size
            }
        }
        StudentRepository.addStudent(student1, counter)
        StudentRepository.addStudent(student2, counter)
        StudentRepository.addStudent(student3, counter)
        StudentRepository.listAllStudent()
    }

    private fun chapter15() {
        testingClasses()
    }

    private fun chapter17() {
        createUser()
    }

    private fun chapter16() {
        enums()
        usingSealedClasses()
    }

    private fun chapter20() {
        val chapter20 = Chapter20()
        chapter20.catchingAnException()
        chapter20.tryCatchAsAnExpression()
        chapter20.callingFunThrowsExceptionMethod()
        chapter20.callingUsingElvisOperatorMethod()
    }
}