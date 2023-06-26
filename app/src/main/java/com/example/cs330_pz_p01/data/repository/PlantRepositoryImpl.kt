package com.example.cs330_pz_p01.data.repository

import com.example.cs330_pz_p01.data.remote.PlantsApi
import com.example.cs330_pz_p01.data.remote.dto.PlantDto
import com.example.cs330_pz_p01.domain.repository.plantRepository
import javax.inject.Inject

class PlantRepositoryImpl @Inject constructor(
    private val api:PlantsApi
) :plantRepository{

    override suspend fun getPlants(): List<PlantDto> {
        return api.getPlants()
    }

    override suspend fun getPlantById(plantId: String): PlantDto {
        return api.getPlantById(plantId)
    }
}