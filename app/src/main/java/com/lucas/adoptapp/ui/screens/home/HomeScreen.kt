package com.lucas.adoptapp.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lucas.adoptapp.ui.composables.ScreenSurface
import com.lucas.adoptapp.utils.HomeViewModelFactory

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
        Column(modifier = Modifier.fillMaxSize()) {
            BannerList()
            RecentNearPetList(newestPetsState)
            NearPetsList(nearPetsState)
        }
    }
}