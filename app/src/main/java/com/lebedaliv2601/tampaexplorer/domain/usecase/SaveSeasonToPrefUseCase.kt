package com.lebedaliv2601.tampaexplorer.domain.usecase

import com.lebedaliv2601.tampaexplorer.domain.model.SeasonModel
import com.lebedaliv2601.tampaexplorer.domain.repository.SeasonPrefRepository
import javax.inject.Inject

class SaveSeasonToPrefUseCase @Inject constructor(private val repository: SeasonPrefRepository) {

    suspend fun invoke(seasonType: String, seasonYear: String){
        repository.saveSeasonToPref(SeasonModel(seasonYear = seasonYear, seasonType = seasonType))
    }

}