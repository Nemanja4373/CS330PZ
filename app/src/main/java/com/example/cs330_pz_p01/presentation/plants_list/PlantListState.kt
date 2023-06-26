package com.example.cs330_pz_p01.presentation.plants_list

import com.example.cs330_pz_p01.domain.model.Plant

data class PlantListState(
    val isLoading: Boolean = false,
    val plants: List<Plant>  = emptyList(),
    val error: String =""

)
