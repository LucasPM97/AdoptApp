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
import com.lucas.adoptapp.ui.theme.DarkText
import com.lucas.adoptapp.ui.theme.LightText
import com.lucas.adoptapp.ui.theme.Red

@Composable
fun DonateBanner(
    modifier: Modifier =
        Modifier
) {
    val bannerBackground = Color(0XFFFCBD59)
    Row(
        modifier = modifier
            .background(bannerBackground, MaterialTheme.shapes.small)
            .padding(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
        ) {
            Text(
                text = stringResource(R.string.donate_title_banner),
                style = MaterialTheme.typography.titleLarge,
                color = DarkText,
            )
            Text(
                text = stringResource(R.string.donate_body_banner),
                style = MaterialTheme.typography.bodyMedium,
                color = DarkText
            )
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .background(
                        Red,
                        MaterialTheme.shapes.small
                    )
                    .weight(1f)
                    .padding(10.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.donate),
                    style = MaterialTheme.typography.bodyMedium,
                    color = LightText,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center),
                    textAlign = TextAlign.Center,
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.four_animals),
            contentDescription = stringResource(R.string.four_animals_content_description),
            modifier = Modifier.weight(1f),
            contentScale = ContentScale.FillBounds,
        )
    }
}

@Composable
@Preview
fun PreviewDonateBanner() {
    AdoptAppTheme {
        DonateBanner(
            modifier = Modifier
                .height(200.dp)
                .width(360.dp)
        )
    }
}