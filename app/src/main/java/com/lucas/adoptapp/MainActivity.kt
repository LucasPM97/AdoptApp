package com.lucas.adoptapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.lucas.adoptapp.ui.screens.home.HomeScreen
import com.lucas.adoptapp.ui.theme.AdoptAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdoptAppTheme {
                // A surface container using the 'background' color from the theme
                HomeScreen()
            }
        }
    }
}