package com.example.cs330_pz_p01.domain.repository

import com.example.cs330_pz_p01.data.remote.dto.PlantDto

interface plantRepository {
    suspend fun  getPlants():List<PlantDto>
    suspend fun  getPlantById(plantId:String): PlantDto

}