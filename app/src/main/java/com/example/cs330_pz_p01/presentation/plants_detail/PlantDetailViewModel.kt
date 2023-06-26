package com.example.cs330_pz_p01.presentation.plants_detail

import android.widget.ResourceCursorTreeAdapter
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.Constraints
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cs330_pz_p01.Room.repository.PlantDatabaseRepository
import com.example.cs330_pz_p01.common.Constants
import com.example.cs330_pz_p01.common.Resource
import com.example.cs330_pz_p01.domain.model.toMyPlant
import com.example.cs330_pz_p01.domain.use_case.get_plant.GetPlantUseCase
import com.example.cs330_pz_p01.domain.use_case.get_plants.GetPlantsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class PlantDetailViewModel @Inject constructor(
    private val getPlantUseCase: GetPlantUseCase,
    private val repository: PlantDatabaseRepository,
    savedStateHandle: SavedStateHandle
):ViewModel(){

    private val _state = mutableStateOf(PlantDetailState())
    val state: State<PlantDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_PLANT_ID)?.let { plantId ->
            getPlant(plantId)
        }
    }

    suspend fun addToDatabase(){
        viewModelScope.launch {
            state.value.plant?.toMyPlant()?.let { repository.isertNewPlant(it) }
        }
    }

    private fun getPlant(plantId:String) {
        getPlantUseCase(plantId).onEach { result->
            when(result){
                is Resource.Success ->{
_state.value = PlantDetailState(plant = result.data)
                }
                is Resource.Error ->{
                    _state.value = PlantDetailState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading ->{
                    _state.value = PlantDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}