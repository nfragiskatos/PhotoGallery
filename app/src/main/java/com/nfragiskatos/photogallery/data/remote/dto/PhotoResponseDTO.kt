package com.nfragiskatos.photogallery.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PhotoResponseDTO(
    @Json(name = "photo")
    val galleryItems: List<GalleryItemDTO>
)
