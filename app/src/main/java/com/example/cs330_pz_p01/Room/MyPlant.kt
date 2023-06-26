package com.example.cs330_pz_p01.Room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plants")
data class MyPlant(
    @PrimaryKey val id: Int,
    val name: String,
    val description: String,
    val sun_side: String,
    val imageUrl :String,
    val watering_frequency: Double,
    val edible: Boolean
)
