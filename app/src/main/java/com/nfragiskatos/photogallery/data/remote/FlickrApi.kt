package com.nfragiskatos.photogallery.data.remote


import com.nfragiskatos.photogallery.BuildConfig
import com.nfragiskatos.photogallery.data.remote.dto.FlickrResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrApi {
    @GET("/services/rest/?method=flickr.interestingness.getList")
    suspend fun fetchPhotos(): FlickrResponseDTO

    @GET("/services/rest/?method=flickr.photos.search")
    suspend fun searchPhotos(@Query("text") query: String) : FlickrResponseDTO
}