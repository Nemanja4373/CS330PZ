package com.example.cs330_pz_p01.Room.repository

import com.example.cs330_pz_p01.Room.MyPlant
import kotlinx.coroutines.flow.Flow

interface PlantDatabaseRepository {

    suspend fun isertNewPlant(plant:MyPlant)

    suspend fun getAllPlantt(): Flow<List<MyPlant>>

    suspend fun deletePlant(id:MyPlant)



}