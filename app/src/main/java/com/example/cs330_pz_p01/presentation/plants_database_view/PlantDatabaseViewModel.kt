package com.example.cs330_pz_p01.presentation.plants_database_view

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cs330_pz_p01.Room.repository.PlantDatabaseRepository
import com.example.cs330_pz_p01.Room.repository.PlantDatabaseRepositoryImpl
import com.example.cs330_pz_p01.domain.model.Plant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlantDatabaseViewModel @Inject constructor(
    private val getPlantsFromDatabase: PlantDatabaseRepository
): ViewModel() {

   private val _state = mutableStateOf(PlantDatabaseState())
    val state : State<PlantDatabaseState> = _state

      init {
          viewModelScope.launch { getAllPlantt() }

    }

    private suspend fun getAllPlantt(){
        getPlantsFromDatabase.getAllPlantt()
            .onEach{
                plants ->
                _state.value = state.value.copy(
                    plants = plants
                )
            }.launchIn(viewModelScope)
    }

}