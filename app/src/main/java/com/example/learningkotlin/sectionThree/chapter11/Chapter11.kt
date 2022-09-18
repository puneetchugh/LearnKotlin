package com.example.learningkotlin.sectionThree.chapter11

class Chapter11(var chapterName: String, var section: String) {
    companion object {
        val TAG = "${Chapter11::class.java}:"

        fun createClassInstance(chapterName: String, section: String): Chapter11 {
            val newChapter = Chapter11(chapterName, section)
            println("$TAG newChapter: ${newChapter.description}")
            return newChapter
        }
    }

    val description
        get() = "$chapterName $section"

    //The functionalities being tested are considering equals() and hashCode not implemented,
    //So commenting out equals() and hashCode()
    /*override fun equals(other: Any?): Boolean {

        if (this === other)
            return true
        if (other == null)
            return false
        if (javaClass != other.javaClass)
            return false
        val obj = other as Chapter11

        if (chapterName != obj.chapterName || section != obj.section)
            return false
        return true
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1

        result = prime * result + chapterName.hashCode()
        result = prime * result + section.hashCode()
        return result
    }*/
}