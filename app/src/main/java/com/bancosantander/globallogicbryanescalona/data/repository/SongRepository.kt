package com.bancosantander.globallogicbryanescalona.data.repository

import com.bancosantander.globallogicbryanescalona.data.remote.model.toSongs
import com.bancosantander.globallogicbryanescalona.data.remote.source.SongRemoteDatSource
import com.bancosantander.globallogicbryanescalona.domain.model.SongList

class SongRepository(
    private val songRemoteDatSource: SongRemoteDatSource
) {
    suspend fun getSong():List<SongList> {
        return songRemoteDatSource.getSong().map { it.toSongs() }
    }
}