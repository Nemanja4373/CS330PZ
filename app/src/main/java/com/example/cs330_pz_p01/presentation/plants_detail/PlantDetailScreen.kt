package com.example.cs330_pz_p01.presentation.plants_detail

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.cs330_pz_p01.domain.model.Plant
import com.example.cs330_pz_p01.presentation.Screen
import com.example.cs330_pz_p01.presentation.plants_list.components.PlantListItem
import com.example.cs330_pz_p01.presentation.plants_list.components.PlantTag
import com.example.cs330_pz_p01.presentation.theme.ui.md_theme_light_background
import kotlinx.coroutines.launch

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PlantDetailScreen(
    viewModel: PlantDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val courotineScope = rememberCoroutineScope()
    Card(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.onBackground)) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            state.plant?.let { plant ->
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(20.dp)
                ) {
                    item {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            AsyncImage(
                                model = plant.imageUrl,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(180.dp)
                                    .clip(CircleShape)
                            )
                            Spacer(modifier = Modifier.height(15.dp))
                            Text(
                                text = plant.name,
                                style = MaterialTheme.typography.titleLarge
                            )
                            Spacer(modifier = Modifier.height(15.dp))
                            Box(
                                modifier = Modifier
                                    .width(220.dp)
                                    .clip(CircleShape)
                                    .background(MaterialTheme.colorScheme.tertiaryContainer),
                                contentAlignment = Alignment.Center
                            ) {
                                Row {
                                    AsyncImage(
                                        model = if (plant.sun_side == "Half") "https://cdn-icons-png.flaticon.com/512/0/370.png"
                                        else "https://icons.veryicon.com/png/o/application/yitao-wireless-icon-library/brightness-3.png",
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(30.dp)
                                            .clip(CircleShape)
                                    )
                                    AsyncImage(
                                        model = if (plant.watering_frequency == 1.0) "https://icon-library.com/images/water-droplet-icon/water-droplet-icon-24.jpg"
                                        else if (0.75 == plant.watering_frequency) "https://cdn2.iconfinder.com/data/icons/water-droplets/100/watersketch_50-03-512.png"
                                        else if (plant.watering_frequency == 0.5) "https://static.thenounproject.com/png/1930872-200.png"
                                        else "https://static.thenounproject.com/png/1930871-200.png",
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(30.dp)
                                            .clip(CircleShape)
                                    )
                                    Text(
                                        text = if (plant.edible) "Edible" else "Non-edible",
                                        color = if (plant.edible) Color.White else Color.Red,
                                        fontStyle = FontStyle.Italic,
                                        textAlign = TextAlign.Center,
                                        style = MaterialTheme.typography.bodyMedium,
                                        modifier = Modifier.padding(vertical = 4.dp)
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(15.dp))
                            Text(
                                text = plant.description,
                                style = MaterialTheme.typography.bodyMedium,
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.height(15.dp))
                            Text(
                                text = "Tags",
                                style = MaterialTheme.typography.headlineMedium,
                                modifier = Modifier.clickable {
                                    courotineScope.launch{
                                        viewModel.addToDatabase()
                                    }
                                }
                            )
                            Spacer(modifier = Modifier.height(15.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                plant.tag.forEach { tag ->
                                    PlantTag(tag = tag)
                                }
                            }
                            Spacer(modifier = Modifier.height(15.dp))
                        }
                    }
                }
            }

            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }

            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}
