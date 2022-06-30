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
import com.lucas.adoptapp.ui.composables.HorizontalPetList
import com.lucas.adoptapp.ui.theme.AdoptAppTheme
import com.lucas.adoptapp.ui.theme.DarkText
import com.lucas.core.mocks.MockLists

@Composable
fun RecentNearPetList(state: NewestPetsUiState) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.recent_list_title),
            style = MaterialTheme.typography.titleLarge,
            color = DarkText,
            modifier = Modifier.padding(start = 20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        HorizontalPetList(
            state.pets,
            isLoading = state.loading
        )
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

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFF5F3F8)
fun PreviewRecentNearPetListLoading() {
    AdoptAppTheme {
        val newestPetsState = NewestPetsUiState(
            loading = true,
            pets = emptyList()
        )
        RecentNearPetList(state = newestPetsState)
    }
}