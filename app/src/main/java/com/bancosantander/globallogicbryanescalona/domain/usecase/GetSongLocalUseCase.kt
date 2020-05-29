package com.bancosantander.globallogicbryanescalona.domain.usecase

import com.bancosantander.core.coroutines.ResultUseCase
import com.bancosantander.globallogicbryanescalona.data.repository.SongRepository
import com.bancosantander.globallogicbryanescalona.domain.model.SongList
import com.bancosantander.globallogicbryanescalona.domain.model.request.SearchRequest
import kotlinx.coroutines.Dispatchers

class GetSongLocalUseCase(
    private val repository: SongRepository
): ResultUseCase<SearchRequest, List<SongList>>(
    backgroundContext = Dispatchers.IO,
    foregroundContext = Dispatchers.Main
) {
    override suspend fun executeOnBackground(params: SearchRequest): List<SongList>? {
      return repository.getLocalSong(term = params.search)
    }
}