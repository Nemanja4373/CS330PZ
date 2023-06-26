package com.example.cs330_pz_p01.Room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao
interface PlantDao {

    @Query("SELECT * FROM plants")
     fun getAllPlants(): Flow<List<MyPlant>>

    @Query("SELECT * FROM plants WHERE id = :plantId")
    fun getPlantById(plantId: Long): MyPlant?

    @Upsert
    suspend fun insertPlant(plants: MyPlant)

    @Update
    suspend fun updatePlant(plants: MyPlant)

    @Delete
    suspend fun deletePlant(plants: MyPlant)
}