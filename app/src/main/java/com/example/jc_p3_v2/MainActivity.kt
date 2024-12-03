package com.example.jc_p3_v2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jc_p3_v2.screens.AuthScreen
import com.example.jc_p3_v2.screens.SendDataScreen
import com.example.jc_p3_v2.screens.ReadDataScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //NAWIGACJA
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "auth") {
                        composable("auth") { AuthScreen(navController) }
                        composable("send") { SendDataScreen(navController) }
                        composable("read") { ReadDataScreen(navController) }
                    }
                }
            }
        }
    }
}