package com.bancosantander.globallogicbryanescalona.data.remote.net

import com.bancosantander.core.base.SearchResponse
import com.bancosantander.globallogicbryanescalona.data.remote.model.AlbumEntry
import com.bancosantander.globallogicbryanescalona.data.remote.model.SongListEntry
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SongRemoteApi {

    @GET("search")
     fun getSong(@Query("term") terms: String,
                        @Query("mediaType") mediaType: String = "music",
                         @Query("limit") limit: String = "20"

    ): Call<SearchResponse<SongListEntry>>

    @GET("lookup")
     fun getAlbums(
        @Query("id") artistId: Long,
        @Query("entity") entity: String = "song"
    ): Call<SearchResponse<AlbumEntry>>


   // https://itunes.apple.com/lookup?id=420075073&entity=song
}