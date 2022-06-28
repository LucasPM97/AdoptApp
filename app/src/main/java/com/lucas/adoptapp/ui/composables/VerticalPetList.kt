package com.lucas.adoptapp.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucas.core.data.models.PetItem

@Composable
fun VerticalPetList(
    pets: List<PetItem>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(vertical = 20.dp),
    verticalArrangement: Arrangement.Vertical = Arrangement.spacedBy(20.dp)
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding,
        verticalArrangement = verticalArrangement,
    ) {
        items(pets) { pet ->
            BigPetItem(
                pet,
                modifier = Modifier.fillMaxWidth()
                    .height(130.dp)
            )
        }
    }
}

