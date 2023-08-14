package com.nfragiskatos.photogallery.ui.photogallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nfragiskatos.photogallery.R
import com.nfragiskatos.photogallery.data.remote.dto.GalleryItemDTO
import com.nfragiskatos.photogallery.databinding.ListItemGalleryBinding

class PhotoViewHolder(
    private val binding: ListItemGalleryBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(galleryItem: GalleryItemDTO) {
        binding.itemImageView.load(galleryItem.url) {
            placeholder(R.drawable.baseline_person_64)
        }
    }
}
class PhotoListAdapter(private val galleryItems: List<GalleryItemDTO>) : RecyclerView.Adapter<PhotoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemGalleryBinding.inflate(inflater, parent, false)
        return PhotoViewHolder(binding)
    }

    override fun getItemCount() = galleryItems.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val item = galleryItems[position]
        holder.bind(item)
    }

}