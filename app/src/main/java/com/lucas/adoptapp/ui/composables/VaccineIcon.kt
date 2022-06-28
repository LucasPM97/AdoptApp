package com.lucas.adoptapp.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Vaccines
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucas.adoptapp.ui.theme.AdoptAppTheme
import com.lucas.adoptapp.ui.theme.VaccineBackground
import com.lucas.adoptapp.ui.theme.White

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
            .size(iconSize.dp)
            .padding((iconSize / 10).dp)
    ) {
        Icon(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            tint = White,
            imageVector = Icons.Outlined.Vaccines,
            contentDescription = "vaccinated pet"
        )
    }
}

@Composable
@Preview
fun PreviewVaccineIcon() {
    AdoptAppTheme {
        VaccineIcon(
            iconSize = 20
        )
    }
}