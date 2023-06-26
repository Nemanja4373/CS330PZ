package com.example.cs330_pz_p01.data.remote.dto

import com.example.cs330_pz_p01.domain.model.Plant
import com.example.cs330_pz_p01.domain.model.PlantDetail

data class PlantDto(
    val description: String,
    val edible: Boolean,
    val id: Int,
    val name: String,
    val sun_side: String,
    val watering_frequency: Double,
    val imageUrl :String,
    val tag : List<String>
)

fun PlantDto.toPlant():Plant{
    return Plant(
        id = id,
        edible =edible,
        name = name,
        sun_side=sun_side,
        watering_frequency=watering_frequency,
        imageUrl = imageUrl,
        tag = tag


    )
}


fun PlantDto.toPlantDetail():PlantDetail{
    return PlantDetail(
        id = id,
        edible =edible,
        name = name,
        sun_side=sun_side,
        watering_frequency=watering_frequency,
        description = description,
        imageUrl = imageUrl,
        tag = tag
    )
}