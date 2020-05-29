package com.bancosantander.globallogicbryanescalona.data.remote.source

import com.bancosantander.core.extension.await
import com.bancosantander.globallogicbryanescalona.data.remote.model.AlbumEntry
import com.bancosantander.globallogicbryanescalona.data.remote.model.SongListEntry
import com.bancosantander.globallogicbryanescalona.data.remote.net.SongRemoteApi

open class SongRemoteDataSource(
    private val songRemoteApi: SongRemoteApi
) {
    suspend fun getSong(term: String):List<SongListEntry>{
        return songRemoteApi.getSong(term).await()!!.results
    }

    suspend fun getAlbum(artistId: Long):List<AlbumEntry>{
        return songRemoteApi.getAlbums(artistId).await()!!.results
    }
}