package com.lucas.adoptapp.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
            BannerList()
            Spacer(modifier= Modifier.height(20.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            RecentNearPetList(newestPetsState)
            Spacer(modifier= Modifier.height(20.dp))
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