package com.bancosantander.globallogicbryanescalona.presentation.ui.adapter.holder

import android.media.MediaPlayer
import androidx.recyclerview.widget.RecyclerView
import com.bancosantander.globallogicbryanescalona.R
import com.bancosantander.globallogicbryanescalona.databinding.ItemSongAlbumBinding
import com.bancosantander.globallogicbryanescalona.domain.model.Album
import com.bancosantander.globallogicbryanescalona.util.getImgPicasso

class AlbumHolder (
    private val binding: ItemSongAlbumBinding
): RecyclerView.ViewHolder(binding.root) {

    private val mediaPlayer = MediaPlayer()
    fun bindEvent(songAlbum: Album, clickListener: (Album, Int) -> Unit) {
        val context = itemView.context
        binding.songA = songAlbum
        val actionIconResource = songAlbum.computeActionIconResource()
        if (actionIconResource != 0) binding.btnPlay.setImageResource(actionIconResource)
        binding.songAlbum.setOnClickListener{

            if(mediaPlayer.isPlaying){
                mediaPlayer.pause();
                binding.btnPlay.setImageResource(R.drawable.ic_pause)
            }else{
                prepareMusicSource(songAlbum.previewUrl!!)
                mediaPlayer.start()
                binding.btnPlay.setImageResource(R.drawable.ic_play_on)
            }
        }

        binding.btnPlay.setOnClickListener {


        }
       // getImgPicasso(r.drawable.ic_play,binding.imageView)
        binding.executePendingBindings()
    }

    private fun prepareMusicSource(url:String){
        mediaPlayer.reset()
        mediaPlayer.setDataSource(url)
        mediaPlayer.prepare()

    }

}