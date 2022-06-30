package com.lucas.adoptapp.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucas.adoptapp.R
import com.lucas.adoptapp.ui.composables.BigPetItem
import com.lucas.adoptapp.ui.composables.EmptyBigPetItem
import com.lucas.adoptapp.ui.theme.AdoptAppTheme
import com.lucas.core.data.models.PetItem
import com.lucas.core.mocks.MockLists

@Composable
fun NearPetsList(state: NearPetsUiState) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = stringResource(R.string.near_list_title),
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.padding(vertical = 10.dp)
        ) {
            if (!state.loading && state.pets.isNotEmpty()) {
                state.pets.forEach { pet ->
                    BigPetItem(
                        pet,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(130.dp)
                    )
                }
            } else {
                for (i in 1..4) {
                    EmptyBigPetItem(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(130.dp)
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFF5F3F8)
fun PreviewNearPetsList() {
    AdoptAppTheme {
        val state = NearPetsUiState(
            loading = false,
            pets = MockLists.createPetList(10)
        )
        NearPetsList(state)
    }
}