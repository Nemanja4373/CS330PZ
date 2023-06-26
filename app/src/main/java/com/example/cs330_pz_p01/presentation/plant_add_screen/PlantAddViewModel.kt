package com.example.cs330_pz_p01.presentation.plant_add_screen

import androidx.lifecycle.ViewModel
import com.example.cs330_pz_p01.Room.PlantDao
import com.example.cs330_pz_p01.Room.repository.PlantDatabaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlantAddViewModel @Inject constructor(
    private val repository: PlantDatabaseRepository

): ViewModel() {
}