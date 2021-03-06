package com.bancosantander.globallogicbryanescalona.presentation.ui.fragment.search

import androidx.lifecycle.ViewModel
import com.bancosantander.core.extension.LiveResult
import com.bancosantander.globallogicbryanescalona.domain.model.SongList
import com.bancosantander.globallogicbryanescalona.domain.model.request.SearchRequest
import com.bancosantander.globallogicbryanescalona.domain.usecase.GetSongLocalUseCase
import com.bancosantander.globallogicbryanescalona.domain.usecase.GetSongUseCase
import com.bancosantander.globallogicbryanescalona.presentation.ui.adapter.SongAdapter


class SearchViewModel(
    private val getSongUseCase: GetSongUseCase,
    private val getSongLocalUseCase: GetSongLocalUseCase
) : ViewModel() {
    lateinit var adapter: SongAdapter
    val songLiveData = LiveResult<List<SongList>>()
    val songLocalLiveData = LiveResult<List<SongList>>()


    fun getSong(term: String) {
        getSongUseCase.execute(liveData = songLiveData, params = SearchRequest(search = term))
    }
    fun getLocalSong(term: String){
        getSongLocalUseCase.execute(liveData = songLocalLiveData,params = SearchRequest(search = term))
    }

    fun initAdapter(clickListener: (SongList, Int) -> Unit) {
        adapter = SongAdapter(mutableListOf(), clickListener)
    }

    fun updateSong(songList: List<SongList>) {
        adapter.setData(songList)
        adapter.notifyDataSetChanged()
    }

}