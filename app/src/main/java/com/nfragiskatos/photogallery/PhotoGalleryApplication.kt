package com.nfragiskatos.photogallery

import android.app.Application
import com.nfragiskatos.photogallery.data.PreferencesRepository

class PhotoGalleryApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        PreferencesRepository.initialize(this)
    }
}