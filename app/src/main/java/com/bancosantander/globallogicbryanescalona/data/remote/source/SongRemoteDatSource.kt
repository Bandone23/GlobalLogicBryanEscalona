package com.bancosantander.globallogicbryanescalona.data.remote.source

import com.bancosantander.core.extension.await
import com.bancosantander.globallogicbryanescalona.data.remote.model.SongListEntry
import com.bancosantander.globallogicbryanescalona.data.remote.net.SongRemoteApi

open class SongRemoteDatSource(
    private val songRemoteApi: SongRemoteApi
) {
    suspend fun getSong():List<SongListEntry>{
        return songRemoteApi.getSong().await()!!.results
    }
}