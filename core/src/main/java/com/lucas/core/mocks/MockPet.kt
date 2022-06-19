package com.lucas.core.mocks

import com.lucas.core.data.models.PetItem
import java.time.LocalDate

object MockPet {
    fun createPetItem(id: Int): PetItem {
        return PetItem(
            id = id.toString(),
            name = getRandomName(),
            imageUrl = getRandomImageUrl(),
            vaccinated = getRandomVaccinated(),
            birthDate = getRandomDate(),
            publishDate = getRandomDate(),
            location = "$id km"
        )
    }

    private val yearList = (2017..2022).toList()
    private val monthList = (1..12).toList()
    private val dayList = (1..30).toList()
    private fun getRandomDate(): LocalDate =
        LocalDate.of(yearList.random(), monthList.random(), dayList.random())

    private fun getRandomName(): String {
        return listOf("Pepe", "Pancho", "Michi", "Popi", "Lara", "Nala", "Lucho", "Pichu")
            .random()
    }

    private fun getRandomImageUrl(): String {
        return listOf(
            "https://www.rspca.org.au/sites/default/files/website/2019/adopt-a-pet-adopting-a-dog-600x375.jpg",
            "https://res.cloudinary.com/petrescue/image/upload/ar_1:1,c_fill,dpr_auto,f_auto,fl_lossy,g_face,q_auto,w_auto:100:500/v1646719568/ysnq7o6zowyrubgj9qdb.jpg",
            "https://compote.slate.com/images/9f6d52b7-4959-44da-92ab-bf6bb9b6634f.jpg",
            "https://www.animalhumanesociety.org/sites/default/files/styles/crop_16_9_960x540/public/media/image/2017-07/IMG_2874_1.jpg?h=3b1ff01e&itok=mIY6iAZv",
            "https://ontariospca.ca/wp-content/uploads/2021/11/Adoptable-Animals-Homepage.png",
            "https://imengine.prod.srp.navigacloud.com/?uuid=f7c67417-8ceb-5254-8e74-44b9946beb85&type=primary&q=72&width=720",
            "https://catadoptionteam.org/wp-content/uploads/2019/07/IMG_3481-1024x754.jpg",
            "https://i.pinimg.com/originals/77/89/95/7789954e2d5af41593fe9d0bba0a6e02.jpg",
            "https://blackkitten.org/wp-content/uploads/2021/08/9fbd333d33aed6cd382a0f7def9f4a0f.png"
        ).random()
    }

    private fun getRandomVaccinated(): Boolean = listOf(true, false).random()
}