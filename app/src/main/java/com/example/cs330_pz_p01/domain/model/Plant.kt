package com.example.cs330_pz_p01.domain.model

data class Plant(
                 val edible: Boolean,
                 val id: Int,
                 val name: String,
                 val sun_side: String,
                 val watering_frequency: Double,
                 val imageUrl :String,
                 val tag: List<String>

)
