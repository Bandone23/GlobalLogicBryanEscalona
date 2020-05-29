package com.bancosantander.globallogicbryanescalona.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bancosantander.globallogicbryanescalona.data.local.model.AlbumEntity

@Dao
interface AlbumDao {
    @Query("SELECT * FROM albums WHERE collectionId = :collectionId ")
    suspend fun getAlbums(collectionId: Long): List<AlbumEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAlbums( albums: List<AlbumEntity>)
}