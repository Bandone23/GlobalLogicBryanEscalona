package com.bancosantander.globallogicbryanescalona.presentation.ui.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.bancosantander.globallogicbryanescalona.R
import com.bancosantander.globallogicbryanescalona.databinding.ItemSongBinding
import com.bancosantander.globallogicbryanescalona.domain.model.SongList
import com.bancosantander.globallogicbryanescalona.util.getImgPicasso


class SongHolder (
    private val binding: ItemSongBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bindEvent(song: SongList, clickListener: (SongList, Int) -> Unit) {
        val context = itemView.context
        binding.song = song

        binding.cardSong.setOnClickListener{ clickListener(song, R.id.card_song)}
        getImgPicasso(song.artworkUrl100,binding.imageView)
        binding.executePendingBindings()
    }


}