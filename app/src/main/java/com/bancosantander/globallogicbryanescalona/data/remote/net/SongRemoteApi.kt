package com.bancosantander.globallogicbryanescalona.data.remote.net

import com.bancosantander.core.base.SearchResponse
import com.bancosantander.globallogicbryanescalona.data.remote.model.AlbumEntry
import com.bancosantander.globallogicbryanescalona.data.remote.model.SongListEntry
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SongRemoteApi {
    @GET("search?term=in+utero&mediaType=music&limit=20")
   suspend fun getSong(): Call<SearchResponse<SongListEntry>>

    @GET("lookup")
   suspend  fun getAlbums(
        @Query("id") artistId: Long,
        @Query("entity") entity: String = "album"
    ): Call<SearchResponse<AlbumEntry>>
}