package com.runbyzo.itmayhavebeenenglishwordstest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.runbyzo.itmayhavebeenenglishwordstest.ui.theme.MainPage
import com.runbyzo.itmayhavebeenenglishwordstest.ui.theme.TestPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "main page"
                ){
                    composable("main page"){
                        MainPage(navController)
                    }

                    composable("test page") {
                        TestPage(navController)
                    }
                }
            }
        }
    }
}


