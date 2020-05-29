package com.bancosantander.globallogicbryanescalona.data.local.source

import com.bancosantander.globallogicbryanescalona.data.local.database.AlbumDao
import com.bancosantander.globallogicbryanescalona.data.local.database.SongListDao
import com.bancosantander.globallogicbryanescalona.data.local.model.AlbumEntity
import com.bancosantander.globallogicbryanescalona.data.local.model.SongListEntity
import com.bancosantander.globallogicbryanescalona.domain.model.Album
import com.bancosantander.globallogicbryanescalona.domain.model.SongList
import com.bancosantander.globallogicbryanescalona.domain.model.toAlbumEntity
import com.bancosantander.globallogicbryanescalona.domain.model.toSongListEntity

open class SongLocalDataSource (
    private val songListDao: SongListDao,
    private val albumDao: AlbumDao
) {
    suspend fun getLocalSong(term:String):List<SongListEntity>{
        return songListDao.getSongList(term)
    }
    suspend fun getLocalAlbum(artistId:Long):List<AlbumEntity>{
        return albumDao.getAlbums(artistId)
    }
    suspend fun saveAlbum(albumEntity: List<Album>){
        return albumDao.saveAlbums(albumEntity.map { it.toAlbumEntity() })
    }
    suspend fun saveSong(songListEntity: List<SongList>){
        songListDao.saveSonList(songListEntity.map { it.toSongListEntity() })
    }
}
