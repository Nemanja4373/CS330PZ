package com.example.cs330_pz_p01.Room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter


@Database(
    entities  =[MyPlant::class],
    version = 1,
    exportSchema = false
)
abstract class PlantDatabase:RoomDatabase() {
    abstract val dao : PlantDao
}