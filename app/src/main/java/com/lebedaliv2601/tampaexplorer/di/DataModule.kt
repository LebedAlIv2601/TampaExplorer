package com.lebedaliv2601.tampaexplorer.di

import android.util.Log
import com.lebedaliv2601.tampaexplorer.data.network.Environment.BASE_API
import com.lebedaliv2601.tampaexplorer.data.network.NHLServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideNHLServices(): NHLServices{
        val retrofit  = Retrofit.Builder()
            .baseUrl(BASE_API)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        return retrofit.create(NHLServices::class.java)
    }
}