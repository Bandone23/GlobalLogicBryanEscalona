package com.bancosantander.globallogicbryanescalona.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bancosantander.globallogicbryanescalona.data.local.model.AlbumEntity
import com.bancosantander.globallogicbryanescalona.data.local.model.SongListEntity
import com.bancosantander.globallogicbryanescalona.util.DATABASE_VERSION

@Database(
    entities = [SongListEntity::class, AlbumEntity::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun songListDao(): SongListDao
    abstract fun albumDao(): AlbumDao
}