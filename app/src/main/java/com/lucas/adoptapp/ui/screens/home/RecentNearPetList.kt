package com.lucas.adoptapp.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucas.adoptapp.R
import com.lucas.adoptapp.ui.theme.AdoptAppTheme
import com.lucas.adoptapp.ui.theme.DarkText
import com.lucas.core.data.models.PetItem
import com.lucas.core.mocks.MockLists

@Composable
fun RecentNearPetList(state: NewestPetsUiState) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.recent_list_title),
            fontSize = 24.sp,
            color = DarkText,
            modifier = Modifier.padding(start = 20.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        if (!state.loading && state.pets.isNotEmpty()) {
            HorizonTalPetList(state.pets)
        }
    }
}

@Composable
fun HorizonTalPetList(pets: List<PetItem>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        items(pets) { pet ->
            Text(text = pet.name)
        }
    }
}


@Composable
@Preview(showBackground = true, backgroundColor = 0xFFF5F3F8)
fun PreviewRecentNearPetList() {
    AdoptAppTheme {

        val newestPetsState = NewestPetsUiState(
            loading = false,
            pets = MockLists.createPetList(10)
        )
        RecentNearPetList(state = newestPetsState)
    }
}