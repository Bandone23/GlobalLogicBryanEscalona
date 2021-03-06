package com.bancosantander.globallogicbryanescalona.domain.usecase

import com.bancosantander.core.coroutines.ResultUseCase
import com.bancosantander.globallogicbryanescalona.data.repository.SongRepository
import com.bancosantander.globallogicbryanescalona.domain.model.SongList
import com.bancosantander.globallogicbryanescalona.domain.model.request.SearchRequest
import kotlinx.coroutines.Dispatchers

class GetSongUseCase (
    private val repository: SongRepository
): ResultUseCase<SearchRequest,List<SongList>>(
    backgroundContext = Dispatchers.IO,
    foregroundContext = Dispatchers.Main
) {
    override suspend fun executeOnBackground(params:SearchRequest): List<SongList>? {
        val remoteSongSearch:List<SongList> = repository.getSong(term= params.search)
         repository.saveSongLocal(remoteSongSearch)
        return remoteSongSearch
    }
}