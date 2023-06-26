package com.example.cs330_pz_p01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cs330_pz_p01.presentation.Screen
import com.example.cs330_pz_p01.presentation.plant_main.PlantMainScreen
import com.example.cs330_pz_p01.presentation.plants_database_view.PlantDatabaseScreen
import com.example.cs330_pz_p01.presentation.plants_detail.PlantDetailScreen
import com.example.cs330_pz_p01.presentation.plants_detail.PlantDetailViewModel
import com.example.cs330_pz_p01.presentation.plants_list.PlantListScreen
import com.example.cs330_pz_p01.presentation.theme.ui.CS330PzP01Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CS330PzP01Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.PlantMainScreen.route){
                        composable(
                            route = Screen.PlantListScreen.route
                        ){
                            PlantListScreen(navController)
                        }
                        composable(
                            route = Screen.PlantDetailScreen.route + "/{plantId}"
                        ){
                            PlantDetailScreen()
                        }
                        composable(
                            route=Screen.PlantMainScreen.route
                        ){
                            PlantMainScreen(navController)
                        }
                        composable(
                            route=Screen.PlantDatabaseScreen.route
                        ){
                            PlantDatabaseScreen(navController)
                        }
                    }
                }
            }
        }
    }
}
