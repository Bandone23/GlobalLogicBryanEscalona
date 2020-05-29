package com.bancosantander.globallogicbryanescalona.presentation.ui.fragment.detail

import androidx.lifecycle.ViewModel
import com.bancosantander.core.extension.LiveResult
import com.bancosantander.globallogicbryanescalona.domain.model.Album
import com.bancosantander.globallogicbryanescalona.domain.model.request.AlbumRequest
import com.bancosantander.globallogicbryanescalona.domain.usecase.GetAlbumLocalUseCase
import com.bancosantander.globallogicbryanescalona.domain.usecase.GetAlbumUseCase
import com.bancosantander.globallogicbryanescalona.presentation.ui.adapter.AlbumAdapter

class AlbumViewModel(
    private val getAlbumUseCase: GetAlbumUseCase,
    private val getAlbumLocalUseCase: GetAlbumLocalUseCase
):ViewModel() {
   lateinit var adapter: AlbumAdapter
    val albumLiveData = LiveResult<List<Album>>()
    val albumLocalLiveData = LiveResult<List<Album>>()

    fun getAlbum(artistId: Long){
        getAlbumUseCase.execute(liveData = albumLiveData,params = AlbumRequest(artistId = artistId))
    }
    fun getLocalAlbum(artistId: Long){
        getAlbumLocalUseCase.execute(liveData = albumLocalLiveData,params = AlbumRequest(artistId = artistId))
    }

    fun initAdapter(clickListener:(Album, Int)-> Unit){
        adapter = AlbumAdapter(mutableListOf(),clickListener)
    }

    fun updateSong(songAlbum: List<Album>) {
        adapter.setData(songAlbum)
        adapter.notifyDataSetChanged()
    }
}