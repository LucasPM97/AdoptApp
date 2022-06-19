package com.lucas.core.data.remote

import com.lucas.core.data.models.PetItem

interface IPetsDataSource {

    suspend fun getRecentNearPets(): List<PetItem>

    suspend fun getNearPets(): List<PetItem>
}