package com.lucas.adoptapp.ui.composables.banners

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucas.adoptapp.R
import com.lucas.adoptapp.ui.theme.AdoptAppTheme
import com.lucas.adoptapp.ui.theme.DarkBlue
import com.lucas.adoptapp.ui.theme.LightText
import com.lucas.adoptapp.ui.theme.White

@Composable
fun SearchBanner(
    modifier: Modifier = Modifier
) {
    val bannerBackground = Color(0XFF6C63FF)

    Row(
        modifier = modifier
            .background(bannerBackground, MaterialTheme.shapes.small)
            .padding(20.dp)
    ) {
        TextColumn(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Image(
            painter = painterResource(id = R.drawable.four_animals),
            contentDescription = "four animals",
            modifier = Modifier.weight(1f),
            contentScale = ContentScale.FillBounds,
        )
    }
}

@Composable
private fun TextColumn(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "¡Dona!",
            style = MaterialTheme.typography.titleLarge,
            color = White
        )
        Text(
            text = stringResource(R.string.banner_search_body),
            style = MaterialTheme.typography.bodyMedium,
            color = White
        )
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .background(
                    DarkBlue,
                    MaterialTheme.shapes.small
                )
                .weight(1f)
                .padding(10.dp)
        ) {
            Text(
                text = stringResource(R.string.banner_search_button),
                style = MaterialTheme.typography.bodyMedium,
                color = LightText,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
            )
        }
    }
}

@Composable
@Preview
fun PreviewSearchBanner() {
    AdoptAppTheme {
        SearchBanner(
            modifier = Modifier
                .height(200.dp)
                .width(360.dp)
        )
    }
}