package com.nfragiskatos.photogallery.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GalleryItemDTO (
    val title: String,
    val id: String,
    @Json(name = "url_s")
    val url: String?
)