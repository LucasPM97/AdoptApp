package com.lucas.adoptapp.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.lucas.adoptapp.ui.theme.*
import com.lucas.core.data.models.PetItem
import com.lucas.core.mocks.MockPet

@Composable
fun BigPetItem(
    pet: PetItem,
    height: Int,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.height(height.dp)
    ) {

        AsyncImage(
            model = pet.imageUrl,
            modifier = Modifier
                .size(height.dp)
                .background(
                    ImagePlaceholder,
                    MaterialTheme.shapes.small
                )
                .clip(MaterialTheme.shapes.small),
            contentScale = ContentScale.Crop,
            contentDescription = "${pet.name} photo"
        )
        PetInfo(pet, maxHeigh = height)
    }
}

@Composable
private fun PetInfo(pet: PetItem, maxHeigh: Int) {
    Column(
        modifier = Modifier
            .background(
                SurfaceBackground,
                RoundedCornerShape(
                    topEndPercent = 10,
                    bottomEndPercent = 10
                )
            )
            .heightIn(max = maxHeigh.dp)
            .widthIn(max = 250.dp)
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = pet.name,
                color = DarkText,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.width(5.dp))
            if (pet.vaccinated) {
                VaccineIcon(
                    iconSize = 10,
                    modifier = Modifier
                        .size(15.dp)
                )
            }
        }
        Text(
            text = "Tiene 2 años",
            color = CaptionText,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(25.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.LocationOn,
                contentDescription = "location",
                tint = DarkText,
                modifier = Modifier.size(16.dp)
            )
            Text(
                text = "Distancia: ${pet.location}",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )
        }

    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFF5F3F8)
fun PreviewBigPetItem() {
    AdoptAppTheme {
        BigPetItem(
            pet = MockPet.createPetItem(1),
            height = 130,
            modifier = Modifier.fillMaxWidth()
        )
    }
}