package com.example.cs330_pz_p01.presentation.plants_database_view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import coil.compose.AsyncImage


@Composable
fun PlantDatabaseScreen(
    navController: NavController,
    viewModel: PlantDatabaseViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Card(
        elevation = CardDefaults.cardElevation(),
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            IconButton(
                modifier = Modifier
                    .background(Color.Transparent)
                    .padding(12.dp),
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.primary
                )
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp)
                ) {
                    Text(
                        text = "Here are my plants:",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.Green,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    state.plants.forEach { plant ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(bottom = 16.dp)
                        ) {
                            Log.d("Kod ikone",plant.imageUrl)
                            AsyncImage(
                                model = plant.imageUrl,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(180.dp)
                                    .clip(CircleShape)
                            )

                            Spacer(modifier = Modifier.width(16.dp))

                            Text(
                                text = plant.name,
                                style = MaterialTheme.typography.titleLarge
                            )

                            // Display other plant information here
                            // ...

                            // Display additional columns here
                            // ...
                        }
                    }
                }
            }
        }
    }


}