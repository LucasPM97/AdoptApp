package com.lucas.adoptapp.ui.composables.banners

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Banner(
    bannerType: BannerTypes,
    modifier: Modifier = Modifier
) {
    when (bannerType) {
        BannerTypes.DonateBanner -> DonateBanner(modifier)
        BannerTypes.SearchBanner -> SearchBanner(modifier)
    }
}

enum class BannerTypes {
    DonateBanner,
    SearchBanner
}