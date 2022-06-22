package com.lebedaliv2601.tampaexplorer.di

import com.lebedaliv2601.tampaexplorer.data.repository.GetGamesRepositoryImpl
import com.lebedaliv2601.tampaexplorer.domain.repository.GetGamesRepository
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

}