package com.nfragiskatos.photogallery.data.remote.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FlickrResponseDTO(
    val photos: PhotoResponseDTO
)
