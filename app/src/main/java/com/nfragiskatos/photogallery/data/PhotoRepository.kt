package com.nfragiskatos.photogallery.data

import com.nfragiskatos.photogallery.data.remote.FlickrApi
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create

class PhotoRepository {

    private val flickrApi: FlickrApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.flickr.com/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()

        flickrApi = retrofit.create<FlickrApi>()
    }

    suspend fun fetchContents() = flickrApi.fetchContents()
}