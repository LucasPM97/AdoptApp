package com.lucas.adoptapp.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Female
import androidx.compose.material.icons.outlined.Male
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
import com.lucas.core.data.models.AgeType
import com.lucas.core.data.models.PetItem
import com.lucas.core.mocks.MockPet

@Composable
fun BigPetItem(
    pet: PetItem,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(
                SurfaceBackground,
                MaterialTheme.shapes.small
            )
    ) {

        val imageShape = RoundedCornerShape(
            topStartPercent = 10,
            bottomStartPercent = 10
        )
        AsyncImage(
            model = pet.imageUrl,
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
                .background(
                    ImagePlaceholder,
                    imageShape
                )
                .clip(imageShape),
            contentScale = ContentScale.Crop,
            contentDescription = "${pet.name} photo"
        )
        Spacer(modifier = Modifier.width(10.dp))
        PetInfo(
            pet,
            Modifier.weight(1f)
        )
        Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = "save")
        Spacer(modifier = Modifier.width(10.dp))
    }
}

@Composable
private fun PetInfo(
    pet: PetItem,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = pet.name,
                color = DarkText,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            Spacer(modifier = Modifier.width(5.dp))
            if (pet.vaccinated) {
                VaccineIcon(
                    iconSize = 20,
                )
            }
        }
        Text(
            text = if (pet.isMale) "Macho" else "Hembra",
            color = CaptionText,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(5.dp))
        Box(
            modifier = Modifier
                .background(DarkBlue, MaterialTheme.shapes.large)
                .padding(
                    vertical = 3.dp,
                    horizontal = 6.dp
                )
        ) {
            Text(
                text = when (pet.age) {
                    AgeType.Adult -> "ADULTO"
                    AgeType.Puppy -> "CACHORRO"
                },
                color = LightText,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
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
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
        )
    }
}