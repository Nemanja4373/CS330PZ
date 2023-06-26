package com.example.cs330_pz_p01.presentation.plants_list

import android.widget.ResourceCursorTreeAdapter
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cs330_pz_p01.common.Resource
import com.example.cs330_pz_p01.domain.use_case.get_plants.GetPlantsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@HiltViewModel
class PlantListViewModel @Inject constructor(
    private val getPlantsUseCase: GetPlantsUseCase
):ViewModel(){

    private val _state = mutableStateOf(PlantListState())
    val state: State<PlantListState> = _state

    init{
        getPlants()
    }

    private fun getPlants() {
        getPlantsUseCase().onEach { result->
            when(result){
                is Resource.Success ->{
_state.value = PlantListState(plants = result.data ?: emptyList())
                }
                is Resource.Error ->{
                    _state.value = PlantListState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading ->{
                    _state.value = PlantListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}