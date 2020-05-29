package com.bancosantander.globallogicbryanescalona.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bancosantander.globallogicbryanescalona.data.local.model.SongListEntity

@Dao
interface SongListDao {
    // todo revisar cual es el campo que esta haciendo el mach
    @Query("SELECT * FROM songList WHERE artistName LIKE ('%' || :artistName || '%')")
    suspend fun getSongList(artistName: String): List<SongListEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveSonList(sonList: List<SongListEntity>)
}