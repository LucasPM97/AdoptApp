package com.lucas.core.data.models

import java.time.LocalDate

data class PetItem(
    val id: String,
    val name: String,
    val imageUrl: String,
    val vaccinated: Boolean,
    val birthDate: LocalDate,
    val publishDate: LocalDate,
    //Temp variable until know how to calculate distance using Firebase
    val location: String
)