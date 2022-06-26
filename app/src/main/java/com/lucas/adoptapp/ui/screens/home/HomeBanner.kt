package com.lucas.adoptapp.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lucas.adoptapp.ui.composables.banners.Banner
import com.lucas.adoptapp.ui.composables.banners.BannerTypes

@Composable
fun HomeBanner() {

    var visibleBanner = rememberSaveable {
        listOf(
            BannerTypes.DonateBanner,
            BannerTypes.SearchBanner
        ).random()
    }

    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Banner(
            visibleBanner,
            modifier = Modifier
                .height(200.dp)
                .width(360.dp)
        )
    }

}