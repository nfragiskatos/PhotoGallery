package com.nfragiskatos.photogallery.ui.photogallery

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nfragiskatos.photogallery.data.PhotoRepository
import com.nfragiskatos.photogallery.data.PreferencesRepository
import com.nfragiskatos.photogallery.data.remote.dto.GalleryItemDTO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private const val TAG = "PhotoGalleryViewModel"
class PhotoGalleryViewModel : ViewModel() {
    private val photoRepository = PhotoRepository()
    private val preferencesRepository = PreferencesRepository.get()

    private val _uiState: MutableStateFlow<PhotoGalleryUiState> = MutableStateFlow(
        PhotoGalleryUiState()
    )
    val uiState : StateFlow<PhotoGalleryUiState>
        get() = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            preferencesRepository.storedQuery.collectLatest {storedQuery ->
                try {
                    val items = fetchGalleryItems(storedQuery)
                    _uiState.update { oldState ->
                        oldState.copy(images = items, query = storedQuery)
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "Failed to fetch galleryItems", e)
                }
            }
        }
    }

    fun setQuery(query: String) {
        viewModelScope.launch {
            preferencesRepository.setStoredQuery(query)
        }
    }

    private suspend fun fetchGalleryItems(query: String) : List<GalleryItemDTO> {
        return if (query.isBlank()) {
            photoRepository.fetchPhotos()
        } else {
            photoRepository.searchPhotos(query)
        }
    }

    data class PhotoGalleryUiState (
        val images: List<GalleryItemDTO> =  listOf(),
        val query: String = "",
    )
}