package com.example.cs330_pz_p01.data.remote

import com.example.cs330_pz_p01.data.remote.dto.PlantDto
import retrofit2.http.GET
import retrofit2.http.Path


interface PlantsApi {

    @GET("/plants")
    suspend fun getPlants(): List<PlantDto>

    @GET("/plants/{plantId}")
    suspend fun  getPlantById(@Path("plantId")plantId:String):PlantDto

}