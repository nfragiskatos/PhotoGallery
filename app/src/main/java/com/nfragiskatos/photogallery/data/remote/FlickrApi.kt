package com.nfragiskatos.photogallery.data.remote

import retrofit2.http.GET

interface FlickrApi {
    @GET("/")
    suspend fun fetchContents(): String
}