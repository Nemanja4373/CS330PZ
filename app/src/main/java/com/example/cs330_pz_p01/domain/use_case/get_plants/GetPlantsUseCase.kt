package com.example.cs330_pz_p01.domain.use_case.get_plants

import com.example.cs330_pz_p01.common.Resource
import com.example.cs330_pz_p01.data.remote.dto.toPlant
import com.example.cs330_pz_p01.domain.model.Plant
import com.example.cs330_pz_p01.domain.repository.plantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import retrofit2.HttpException
import java.io.IOException

import javax.inject.Inject

class GetPlantsUseCase @Inject constructor(
    private val repository: plantRepository
) {
    operator fun invoke(): Flow<Resource<List<Plant>>> = flow {
        try {
            emit(Resource.Loading())
            val plants = repository.getPlants().map {it.toPlant()}
            emit(Resource.Success(plants))
        }catch (e:HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        }catch (e: IOException){
            emit(Resource.Error("Could'nt reach server. Check your internet connection :)"))
        }
    }


}