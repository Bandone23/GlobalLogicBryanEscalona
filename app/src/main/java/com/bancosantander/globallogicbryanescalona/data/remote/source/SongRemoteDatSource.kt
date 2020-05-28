package com.bancosantander.globallogicbryanescalona.data.remote.source

import com.bancosantander.core.extension.await
import com.bancosantander.globallogicbryanescalona.data.remote.model.AlbumEntry
import com.bancosantander.globallogicbryanescalona.data.remote.model.SongListEntry
import com.bancosantander.globallogicbryanescalona.data.remote.net.SongRemoteApi
import com.bancosantander.globallogicbryanescalona.domain.model.Album

open class SongRemoteDatSource(
    private val songRemoteApi: SongRemoteApi
) {
    suspend fun getSong():List<SongListEntry>{
        return songRemoteApi.getSong().await()!!.results
    }

    suspend fun getAlbum(artistId: Long):List<AlbumEntry>{
        return songRemoteApi.getAlbums(artistId).await()!!.results
    }
}