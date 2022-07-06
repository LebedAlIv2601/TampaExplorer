package com.lebedaliv2601.tampaexplorer.domain.model

data class PlayerModel(
    val id: Long,
    val name: String,
    val playerType: String,
    val seasonTotal: Int
)