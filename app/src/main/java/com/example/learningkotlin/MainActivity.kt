package com.example.learningkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.learningkotlin.section.Chapter2
import com.example.learningkotlin.section.Chapter3.kotlinStrings
import com.example.learningkotlin.section.Chapter3.kotlinStringsOperations
import com.example.learningkotlin.section.Chapter3.pairsAndTriplets
import com.example.learningkotlin.section.Chapter3.typeConversion
import com.example.learningkotlin.section.Chapter5.decreasingRanges
import com.example.learningkotlin.section.Chapter5.forLoops
import com.example.learningkotlin.section.Chapter5.increasingRanges
import com.example.learningkotlin.section.Chapter5.labels
import com.example.learningkotlin.section.Chapter5.repeatForLoops
import com.example.learningkotlin.section.Chapter5.sealedClassesWithWhen
import com.example.learningkotlin.section.Chapter5.whenInKotlin
import com.example.learningkotlin.section.Chapter7.checkDivideIfWholeSolution
import com.example.learningkotlin.section.Chapter7.elvisOperator
import com.example.learningkotlin.section.Chapter7.kotlinNullable
import com.example.learningkotlin.section.Chapter7.kotlinSmartCasts
import com.example.learningkotlin.section.Chapter7.notNullAssertions
import com.example.learningkotlin.section.Chapter7.safeCalls

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chapter2()
        chapter3()
        chapter5()
        chapter7()
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

    private fun chapter5(){
        increasingRanges()
        decreasingRanges()
        forLoops()
        labels()
        whenInKotlin()
        sealedClassesWithWhen()
        repeatForLoops(6)
    }

    private fun chapter7(){
        kotlinNullable()
        kotlinSmartCasts()
        notNullAssertions()
        elvisOperator()
        checkDivideIfWholeSolution()
        safeCalls()
    }
}