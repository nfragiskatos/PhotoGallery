package com.nfragiskatos.photogallery.data

import com.nfragiskatos.photogallery.data.remote.FlickrApi
import com.nfragiskatos.photogallery.data.remote.PhotoInterceptor
import com.nfragiskatos.photogallery.data.remote.dto.GalleryItemDTO
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class PhotoRepository {

    private val flickrApi: FlickrApi

    init {
        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(PhotoInterceptor())
            .build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.flickr.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()

        flickrApi = retrofit.create<FlickrApi>()
    }

    suspend fun fetchPhotos(): List<GalleryItemDTO>
        = flickrApi.fetchPhotos().photos.galleryItems

    suspend fun searchPhotos(query: String) : List<GalleryItemDTO>
        = flickrApi.searchPhotos(query).photos.galleryItems
}