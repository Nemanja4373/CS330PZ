package com.example.cs330_pz_p01.di

import android.app.Application
import android.content.Context
import androidx.compose.ui.unit.Constraints
import androidx.room.Room
import com.example.cs330_pz_p01.Room.PlantDao
import com.example.cs330_pz_p01.Room.PlantDatabase
import com.example.cs330_pz_p01.Room.repository.PlantDatabaseRepository
import com.example.cs330_pz_p01.Room.repository.PlantDatabaseRepositoryImpl
import com.example.cs330_pz_p01.common.Constants
import com.example.cs330_pz_p01.data.remote.PlantsApi
import com.example.cs330_pz_p01.data.repository.PlantRepositoryImpl
import com.example.cs330_pz_p01.domain.model.Plant
import com.example.cs330_pz_p01.domain.repository.plantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object AppModule {

    @Provides
    @Singleton
    fun providePlantsApi(): PlantsApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PlantsApi::class.java)

    }
    @Provides
    @Singleton
    fun providesPlantRepository(api:PlantsApi):plantRepository{
        return PlantRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun providePlantDetailDatabase(context: Context): PlantDatabase {
        return Room.databaseBuilder(
            context,
            PlantDatabase::class.java,
            "plant_detail_database"
        ).build()
    }

    @Provides
    @Singleton
    fun providePlantDetailDao(database: PlantDatabase): PlantDao {
        return database.dao
    }


    @Provides
    @Singleton
    fun providePlantDatabaseRepository(db: PlantDatabase) : PlantDatabaseRepository{
        return PlantDatabaseRepositoryImpl(db.dao)
    }

}