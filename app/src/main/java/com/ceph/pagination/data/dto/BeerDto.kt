package com.ceph.pagination.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class BeerDto(
    val id: Int,
    val name: String,
    val tagline: String,
    val description: String,
    val firstBrewed: String,
    val imageUrl: String?
)
