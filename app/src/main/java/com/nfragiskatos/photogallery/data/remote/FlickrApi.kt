package com.nfragiskatos.photogallery.data.remote

import com.nfragiskatos.photogallery.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrApi {
    @GET("/services/rest")
    suspend fun fetchPhotos(
        @Query("method") method: String = "flickr.interestingness.getList",
        @Query("api_key") apiKey: String = BuildConfig.flickrApiKey,
        @Query("format") format: String = "json",
        @Query("nojsoncallback") noJsonCallback: String = "1",
        @Query("extras") extras: String = "url_s"
    ): String
}