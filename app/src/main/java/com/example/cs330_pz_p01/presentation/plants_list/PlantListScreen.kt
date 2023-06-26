package com.example.cs330_pz_p01.presentation.plants_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.cs330_pz_p01.domain.model.Plant
import com.example.cs330_pz_p01.presentation.Screen
import com.example.cs330_pz_p01.presentation.plants_list.components.PlantListItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantListScreen(
    navController: NavController,
    viewModel: PlantListViewModel = hiltViewModel()
){
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()){
        TopAppBar(
            title = { Text("My plants") },
            actions = {
                IconButton(
                    onClick = { navController.navigate(Screen.PlantDatabaseScreen.route) }
                ) {
                    Icon(Icons.Filled.List, contentDescription = "List")
                }
            }
        )
        Spacer(modifier = Modifier.height(15.dp))

        LazyColumn(modifier = Modifier.fillMaxSize().padding(0.dp,50.dp,0.dp,0.dp)){
            items(state.plants){  plant->
                PlantListItem(
                    plant = plant,
                    onItemClick = {
                    navController.navigate(Screen.PlantDetailScreen.route + "/${plant.id}")
                }
                )
            }
        }
        if (state.error.isNotBlank()){

            Text(
                text= state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )

        }
        if (state.isLoading){
            CircularProgressIndicator(modifier =  Modifier.align(Alignment.Center))
        }
    }
}