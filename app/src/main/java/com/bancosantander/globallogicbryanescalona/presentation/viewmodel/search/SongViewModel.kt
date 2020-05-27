package com.bancosantander.globallogicbryanescalona.presentation.viewmodel.search

import androidx.lifecycle.ViewModel
import com.bancosantander.core.extension.LiveResult
import com.bancosantander.globallogicbryanescalona.domain.model.SongList
import com.bancosantander.globallogicbryanescalona.domain.usecase.GetSongUseCase


class SongViewModel(
    private val getSongUseCase: GetSongUseCase
): ViewModel() {
   // lateinit var adapter: SongAdapter
    val songLiveData = LiveResult<List<SongList>>()


    fun getSong(){
        getSongUseCase.execute(liveData = songLiveData)
    }

    fun initAdapter(clickListener:(SongList,Int)-> Unit){
       // adapter = SongAdapter(mutableListOf(),clickListener)
    }

    fun updateSong(songList: List<SongList>) {
       // adapter.setData(songList)
     //   adapter.notifyDataSetChanged()
    }

}