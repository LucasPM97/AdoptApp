package com.lucas.adoptapp.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lucas.adoptapp.ui.composables.ScreenSurface
import com.lucas.adoptapp.ui.theme.AdoptAppTheme
import com.lucas.adoptapp.utils.HomeViewModelFactory
import com.lucas.core.mocks.MockLists

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(
        factory = HomeViewModelFactory()
    )
) {
    val nearPetsState by viewModel.nearPetsUiState.collectAsState()
    val newestPetsState by viewModel.newestPetsUiState.collectAsState()

    HomeScreenContent(newestPetsState, nearPetsState)
}

@Composable
private fun HomeScreenContent(
    newestPetsState: NewestPetsUiState,
    nearPetsState: NearPetsUiState
) {
    ScreenSurface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            HomeBanner()
            Spacer(modifier = Modifier.height(20.dp))
            RecentNearPetList(newestPetsState)
            Spacer(modifier = Modifier.height(20.dp))
            NearPetsList(nearPetsState)
        }
    }
}

@Composable
@Preview
fun PreviewHomeScreenContent() {
    AdoptAppTheme {
        HomeScreenContent(
            nearPetsState = NearPetsUiState(
                loading = false,
                pets = MockLists.createPetList(10)
            ),
            newestPetsState = NewestPetsUiState(
                loading = false,
                pets = MockLists.createPetList(20)
            )
        )
    }
}