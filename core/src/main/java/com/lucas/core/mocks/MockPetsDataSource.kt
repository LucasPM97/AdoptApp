package com.lucas.core.mocks

import com.lucas.core.data.models.PetItem
import com.lucas.core.data.remote.IPetsDataSource
import kotlinx.coroutines.delay

class MockPetsDataSource : IPetsDataSource {
    override suspend fun getRecentNearPets(): List<PetItem> {
        delay(2000)
        return MockLists.createPetList(20)
    }

    override suspend fun getNearPets(): List<PetItem> {
        delay(2000)
        return MockLists.createPetList(4)
    }
}