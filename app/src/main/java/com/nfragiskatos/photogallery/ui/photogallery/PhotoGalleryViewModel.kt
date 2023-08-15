package com.nfragiskatos.photogallery.ui.photogallery

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nfragiskatos.photogallery.data.PhotoRepository
import com.nfragiskatos.photogallery.data.remote.dto.GalleryItemDTO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

private const val TAG = "PhotoGalleryViewModel"
class PhotoGalleryViewModel : ViewModel() {
    private val photoRepository = PhotoRepository()

    private val _galleryItems: MutableStateFlow<List<GalleryItemDTO>> = MutableStateFlow<List<GalleryItemDTO>>(emptyList())
    val galleryItems: StateFlow<List<GalleryItemDTO>>
        get() = _galleryItems.asStateFlow()

    init {
        viewModelScope.launch {
            try {
//                val items = photoRepository.fetchPhotos()
                val items = photoRepository.searchPhotos("bicycle")
                _galleryItems.value = items
            } catch (e: Exception) {
                Log.e(TAG, "Failed to fetch galleryItems", e)
            }
        }
    }
}