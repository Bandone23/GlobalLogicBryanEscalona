package com.bancosantander.globallogicbryanescalona.data.repository

import com.bancosantander.globallogicbryanescalona.data.local.model.toAlbum
import com.bancosantander.globallogicbryanescalona.data.local.model.toSongList
import com.bancosantander.globallogicbryanescalona.data.local.source.SongLocalDataSource
import com.bancosantander.globallogicbryanescalona.data.remote.model.toAlbum
import com.bancosantander.globallogicbryanescalona.data.remote.model.toSongs
import com.bancosantander.globallogicbryanescalona.data.remote.source.SongRemoteDataSource
import com.bancosantander.globallogicbryanescalona.domain.model.Album
import com.bancosantander.globallogicbryanescalona.domain.model.SongList

class SongRepository(
    private val songRemoteDataSource: SongRemoteDataSource,
    private val songLocalDataSource: SongLocalDataSource
) {
    suspend fun getSong(term: String): List<SongList> {
        return songRemoteDataSource.getSong(term).map { it.toSongs() }
    }

    suspend fun getAlbum(artistId: Long): List<Album> {
        return songRemoteDataSource.getAlbum(artistId).map { it.toAlbum() }
    }

    suspend fun getLocalSong(term: String): List<SongList> {
        return songLocalDataSource.getLocalSong(term).map { it.toSongList() }
    }

    suspend fun getLocalAlbum(artistId: Long): List<Album> {
        return songLocalDataSource.getLocalAlbum(artistId).map { it.toAlbum() }
    }

    /*save local */
    suspend fun saveSongLocal(songList: List<SongList>) {
        songLocalDataSource.saveSong(songList)
    }

    suspend fun saveAlbumLocal(album: List<Album>) {
        songLocalDataSource.saveAlbum(album)
    }
}