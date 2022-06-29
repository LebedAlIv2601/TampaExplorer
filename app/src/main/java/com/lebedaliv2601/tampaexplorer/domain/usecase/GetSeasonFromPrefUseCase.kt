package com.lebedaliv2601.tampaexplorer.domain.usecase

import com.lebedaliv2601.tampaexplorer.domain.model.SeasonModel
import com.lebedaliv2601.tampaexplorer.domain.repository.SeasonPrefRepository
import javax.inject.Inject

class GetSeasonFromPrefUseCase @Inject constructor(private val repository: SeasonPrefRepository) {

    suspend fun invoke(): SeasonModel{
        return repository.getSeasonFromPref()
    }

}