package com.example.learningkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
import com.example.learningkotlin.sectionTwo.Chapter8.arrays
import com.example.learningkotlin.sectionTwo.Chapter8.iterating
import com.example.learningkotlin.sectionTwo.Chapter8.listMethods
import com.example.learningkotlin.sectionTwo.Chapter8.lists
import com.example.learningkotlin.sectionTwo.Chapter8.mutableLists
import com.example.learningkotlin.sectionTwo.Chapter8.primitiveArrays

class MainActivity : AppCompatActivity() {
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
}