package com.lucas.adoptapp.ui.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lucas.adoptapp.ui.theme.ScreenBackground

@Composable
fun ScreenSurface(content: @Composable () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = ScreenBackground
    ) {
        content()
    }
}