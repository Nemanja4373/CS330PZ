package com.example.cs330_pz_p01.presentation.plants_database_view

import com.example.cs330_pz_p01.Room.MyPlant

data class PlantDatabaseState(
    val plants:List<MyPlant> = emptyList()
)
