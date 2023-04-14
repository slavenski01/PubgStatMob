package com.example.pubgstatmob.data.models

data class PlayerApiModel(
    val data: List<Data>
)

data class Data(
    val type: String,
    val id: String,
    val attributes: Attributes
)

data class Attributes(
    val name: String,
    val sharId: String,
    val stats: Stats,
    val createdAt: String,
    val updatedAt: String,
    val patchVersion: String,
    val titleId: String
)

data class Stats(
    val name: String
)