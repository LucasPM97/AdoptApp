package com.lucas.adoptapp.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Vaccines
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.lucas.adoptapp.ui.theme.VaccineBackground

@Composable
fun VaccineIcon(
    iconSize: Int,
    modifier: Modifier = Modifier
) {
    val boxShape = CircleShape
    Box(
        modifier = modifier
            .background(VaccineBackground, boxShape)
            .clip(boxShape)
    ) {
        Icon(
            modifier = Modifier
                .size(iconSize.dp)
                .align(Alignment.Center),
            tint = com.lucas.adoptapp.ui.theme.VaccineIcon,
            imageVector = Icons.Outlined.Vaccines,
            contentDescription = "vaccinated pet"
        )
    }
}