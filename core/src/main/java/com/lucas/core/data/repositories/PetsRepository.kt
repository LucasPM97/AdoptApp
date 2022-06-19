package com.lucas.core.data.repositories

import com.lucas.core.data.models.PetItem
import com.lucas.core.data.remote.IPetsDataSource
import com.lucas.core.data.remote.responses.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

interface IPetsRepository {
    suspend fun getRecentNearPets(): Response<List<PetItem>>
    suspend fun getNearPets(): Response<List<PetItem>>
    suspend fun savePet()
}

class PetsRepository(val dataSource: IPetsDataSource) : IPetsRepository {
    override suspend fun getRecentNearPets(): Response<List<PetItem>> =
        withContext(Dispatchers.IO) {
            val response = try {
                dataSource.getRecentNearPets()
            } catch (e: Exception) {
                return@withContext Response.Error("There was an error trying to connect with the server.")
            }

            return@withContext Response.Success(data = response)
        }

    override suspend fun getNearPets(): Response<List<PetItem>> = withContext(Dispatchers.IO) {
        val response = try {
            dataSource.getNearPets()
        } catch (e: Exception) {
            return@withContext Response.Error("There was an error trying to connect with the server.")
        }

        return@withContext Response.Success(data = response)
    }

    override suspend fun savePet() {
        TODO("Not yet implemented")
    }
}