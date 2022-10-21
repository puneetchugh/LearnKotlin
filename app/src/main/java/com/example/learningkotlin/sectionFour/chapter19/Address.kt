package com.example.learningkotlin.sectionFour.chapter19

data class Address @JvmOverloads constructor(
    @JvmField val streetLine1: String,
    @JvmField val streetLine2: String?,
    @JvmField val city: String,
    @JvmField val stateOrProvince: String,
    @JvmField val postalCode: String,
    @JvmField val country: String = "United States"
)