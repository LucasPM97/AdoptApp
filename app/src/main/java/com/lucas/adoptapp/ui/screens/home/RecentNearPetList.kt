package com.lucas.adoptapp.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            fontSize = 24.sp,
            color = DarkText,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        if (!state.loading && state.pets.isNotEmpty()) {
            HorizontalPetList(state.pets)
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