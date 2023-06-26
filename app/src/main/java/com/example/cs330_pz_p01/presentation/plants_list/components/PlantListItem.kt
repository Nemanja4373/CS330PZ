package com.example.cs330_pz_p01.presentation.plants_list.components

import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cs330_pz_p01.domain.model.Plant

@Composable
fun PlantListItem(
    plant: Plant,
    onItemClick: (Plant) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(plant) }
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            AsyncImage(
                model = plant.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
            )
            Text(
                text = plant.name,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Box(modifier = Modifier
                .width(160.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.tertiaryContainer),
                contentAlignment = Alignment.Center


            ){
                Row() {
                    AsyncImage(
                        model = if (plant.sun_side == "Half") "https://cdn-icons-png.flaticon.com/512/0/370.png"
                        else "https://icons.veryicon.com/png/o/application/yitao-wireless-icon-library/brightness-3.png",
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                    )
                    AsyncImage(
                        model = if (plant.watering_frequency ==1.0) "https://icon-library.com/images/water-droplet-icon/water-droplet-icon-24.jpg"
                        else if(0.75==plant.watering_frequency ) "https://cdn2.iconfinder.com/data/icons/water-droplets/100/watersketch_50-03-512.png"
                        else if(plant.watering_frequency == 0.5)"https://static.thenounproject.com/png/1930872-200.png"
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
                    )}
                }
        }
    }
}
