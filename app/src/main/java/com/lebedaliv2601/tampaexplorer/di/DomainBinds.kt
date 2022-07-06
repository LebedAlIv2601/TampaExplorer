package com.lebedaliv2601.tampaexplorer.di

import com.lebedaliv2601.tampaexplorer.data.repository.GetGameInfoRepositoryImpl
import com.lebedaliv2601.tampaexplorer.data.repository.GetGamesRepositoryImpl
import com.lebedaliv2601.tampaexplorer.data.repository.SeasonPrefRepositoryImpl
import com.lebedaliv2601.tampaexplorer.domain.repository.GetGameInfoRepository
import com.lebedaliv2601.tampaexplorer.domain.repository.GetGamesRepository
import com.lebedaliv2601.tampaexplorer.domain.repository.SeasonPrefRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DomainBinds {

    @Binds
    fun getGamesRepositoryImplToInterface(
        repository: GetGamesRepositoryImpl
    ): GetGamesRepository

    @Binds
    fun seasonPrefRepositoryImplToInterface(
        repository: SeasonPrefRepositoryImpl
    ): SeasonPrefRepository

    @Binds
    fun getGameInfoRepositoryImplToInterface(
        repository: GetGameInfoRepositoryImpl
    ): GetGameInfoRepository

}