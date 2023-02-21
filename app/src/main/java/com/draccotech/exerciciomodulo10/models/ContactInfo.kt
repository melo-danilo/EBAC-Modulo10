package com.draccotech.exerciciomodulo10.models

data class ContactInfo(
    val name: String,
    val phone: String,
    var first: Boolean = false
)
