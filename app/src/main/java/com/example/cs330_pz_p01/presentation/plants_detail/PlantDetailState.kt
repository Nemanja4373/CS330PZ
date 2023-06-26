package com.example.cs330_pz_p01.presentation.plants_detail

import com.example.cs330_pz_p01.domain.model.Plant
import com.example.cs330_pz_p01.domain.model.PlantDetail

data class PlantDetailState(
    val isLoading: Boolean = false,
    val plant: PlantDetail? = null,
    val error: String =""

)
