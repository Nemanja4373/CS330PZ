package com.example.cs330_pz_p01.presentation.plant_main

import android.media.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.cs330_pz_p01.presentation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay


@Composable

fun PlantMainScreen(
    navControler:NavController,

) {
    val logoUrl = "https://e7.pngegg.com/pngimages/139/668/png-clipart-leaf-plant-logo-root-plant-leaf-logo.png"

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = logoUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(180.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(modifier = Modifier.align(CenterHorizontally),
                text = "WELCOME TO",
                style = MaterialTheme.typography.headlineLarge,
                color = Color.Green
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(modifier = Modifier.align(CenterHorizontally),
                text = "PLANTIFY",
                style = MaterialTheme.typography.titleLarge,
                color = Color.Green
            )

        }
    }
    LaunchedEffect(key1 = true) {
        delay(3000) // Adjust the delay duration as needed
        navControler.navigate(Screen.PlantListScreen.route)
    }
}