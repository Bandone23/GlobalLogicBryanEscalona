package com.bancosantander.globallogicbryanescalona.presentation.ui.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.bancosantander.globallogicbryanescalona.R
import com.bancosantander.globallogicbryanescalona.databinding.ItemSongAlbumBinding
import com.bancosantander.globallogicbryanescalona.domain.model.Album
import com.bancosantander.globallogicbryanescalona.util.getImgPicasso

class AlbumHolder (
    private val binding: ItemSongAlbumBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bindEvent(songAlbum: Album, clickListener: (Album, Int) -> Unit) {
        val context = itemView.context
        binding.songA = songAlbum

        binding.songAlbum.setOnClickListener{ clickListener(songAlbum, R.id.song_album)}
        getImgPicasso(songAlbum.artworkUrl100!!,binding.imageView)
        binding.executePendingBindings()
    }


}