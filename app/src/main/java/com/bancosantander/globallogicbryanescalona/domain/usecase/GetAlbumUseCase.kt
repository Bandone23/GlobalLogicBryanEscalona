package com.bancosantander.globallogicbryanescalona.domain.usecase


import com.bancosantander.core.coroutines.ResultUseCase
import com.bancosantander.globallogicbryanescalona.data.repository.SongRepository
import com.bancosantander.globallogicbryanescalona.domain.model.Album
import com.bancosantander.globallogicbryanescalona.domain.model.request.AlbumRequest
import kotlinx.coroutines.Dispatchers

class GetAlbumUseCase(
    private val repository: SongRepository
):ResultUseCase<AlbumRequest,List<Album>>(
    backgroundContext = Dispatchers.IO,
    foregroundContext = Dispatchers.Main
) {
    override suspend fun executeOnBackground(params:AlbumRequest): List<Album>? {
     val remoteAlbum:List<Album> = repository.getAlbum(artistId = params.artistId)
        repository.saveAlbumLocal(remoteAlbum)
      return  remoteAlbum
    }
}