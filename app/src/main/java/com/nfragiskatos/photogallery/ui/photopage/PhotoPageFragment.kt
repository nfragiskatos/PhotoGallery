package com.nfragiskatos.photogallery.ui.photopage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nfragiskatos.photogallery.databinding.FragmentPhotoPageBinding

private const val TAG = "PhotoPageFragment"
class PhotoPageFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPhotoPageBinding.inflate(
            inflater,
            container,
            false
        )
        Log.i(TAG, "Made it")
        return binding.root
    }
}