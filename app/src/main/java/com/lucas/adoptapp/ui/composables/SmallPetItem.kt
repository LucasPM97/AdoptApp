package com.lucas.adoptapp.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.lucas.adoptapp.ui.theme.AdoptAppTheme
import com.lucas.adoptapp.ui.theme.ImagePlaceholder
import com.lucas.core.data.models.PetItem
import com.lucas.core.mocks.MockPet

@Composable
fun SmallPetItem(pet: PetItem, modifier: Modifier = Modifier) {
    val shape = MaterialTheme.shapes.small
    Box(
        modifier = modifier
            .background(ImagePlaceholder, shape)
            .clip(shape)
    ) {
        AsyncImage(
            model = pet.imageUrl,
            modifier = Modifier
                .fillMaxSize()
                .clip(shape),
            contentScale = ContentScale.Crop,
            contentDescription = "${pet.name} photo"
        )
        if (pet.vaccinated) {
            VaccineIcon(
                iconSize = 12,
                modifier = Modifier
                    .padding(5.dp)
                    .size(18.dp)
                    .align(Alignment.BottomEnd)
            )
        }
    }
}


@Composable
@Preview(showBackground = true, backgroundColor = 0xFFF5F3F8)
fun PreviewSmallPetItem() {
    AdoptAppTheme {
        SmallPetItem(
            pet = MockPet.createPetItem(1),
            modifier = Modifier
                .size(80.dp)
        )
    }
}