package com.lucas.core.mocks

import com.lucas.core.data.models.PetItem

object MockLists {
    fun createPetList(size: Int): List<PetItem> {
        val mockedList: MutableList<PetItem> = mutableListOf()

        for (i in (1..size)) {
            mockedList.add(MockPet.createPetItem(i))
        }

        return mockedList
    }
}