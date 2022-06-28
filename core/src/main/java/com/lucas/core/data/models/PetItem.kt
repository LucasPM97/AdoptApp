package com.lucas.core.data.models

data class PetItem(
    val id: String,
    val name: String,
    val imageUrl: String,
    val vaccinated: Boolean,
    val isMale: Boolean,
    val age: AgeType
)

enum class AgeType {
    Adult,
    Puppy
}
