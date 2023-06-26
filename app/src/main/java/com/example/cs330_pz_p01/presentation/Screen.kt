package com.example.cs330_pz_p01.presentation

sealed class Screen(val route:String){
    object PlantListScreen:Screen("coin_list_screen")
    object PlantDetailScreen:Screen("coin_detail_screen")
    object PlantMainScreen:Screen("plant_main_screen")
    object PlantDatabaseScreen:Screen("plant_database_screen")
    object PlantAddScreen:Screen("plant_add_screen")
}
