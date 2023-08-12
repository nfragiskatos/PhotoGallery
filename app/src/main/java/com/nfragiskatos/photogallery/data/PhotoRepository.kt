package com.nfragiskatos.photogallery.data

import com.nfragiskatos.photogallery.data.remote.FlickrApi
import com.nfragiskatos.photogallery.data.remote.dto.GalleryItemDTO
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class PhotoRepository {

    private val flickrApi: FlickrApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.flickr.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        flickrApi = retrofit.create<FlickrApi>()
    }

    suspend fun fetchContents(): List<GalleryItemDTO> = flickrApi.fetchPhotos().photos.galleryItems
}