package com.example.cs330_pz_p01.domain.model

import com.example.cs330_pz_p01.Room.MyPlant

data class PlantDetail(
    val description: String,
    val edible: Boolean,
    val id: Int,
    val name: String,
    val sun_side: String,
    val watering_frequency: Double,
    val imageUrl : String,
    val tag : List<String>
)


fun PlantDetail.toMyPlant():MyPlant{
    return MyPlant(
        id=id,
        name=name,
        description=description,
        sun_side=sun_side,
        edible = edible,
        imageUrl =imageUrl,
        watering_frequency = watering_frequency
    )
}