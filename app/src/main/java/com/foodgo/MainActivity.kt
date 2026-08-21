package com.foodgo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.foodgo.ui.navigation.FoodGoNavHost
import com.foodgo.ui.theme.FoodGoTheme

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            FoodGoTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) {
                    FoodGoNavHost(onExit = { finish() })
                }
            }
        }
    }
}