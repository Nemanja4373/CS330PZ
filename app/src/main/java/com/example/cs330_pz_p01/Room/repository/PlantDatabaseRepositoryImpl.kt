package com.example.cs330_pz_p01.Room.repository

import com.example.cs330_pz_p01.Room.MyPlant
import com.example.cs330_pz_p01.Room.PlantDao
import kotlinx.coroutines.flow.Flow

class PlantDatabaseRepositoryImpl(
    private val dao:PlantDao
):PlantDatabaseRepository {
    override suspend fun isertNewPlant(plant: MyPlant) {
        dao.insertPlant(plant)
    }

    override suspend fun getAllPlantt(): Flow<List<MyPlant>> {
       return dao.getAllPlants()
    }

    override suspend fun deletePlant(id: MyPlant) {
        dao.deletePlant(id)
    }

}