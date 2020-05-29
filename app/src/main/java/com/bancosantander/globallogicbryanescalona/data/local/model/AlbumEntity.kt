package com.bancosantander.globallogicbryanescalona.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bancosantander.globallogicbryanescalona.domain.model.Album
import com.bancosantander.globallogicbryanescalona.util.TABLE_ALBUMS

@Entity(tableName = TABLE_ALBUMS)
data class AlbumEntity(
    @PrimaryKey  val trackCount: Int,
    val collectionId: Long,
    val wrapperType: String?,
    val artistId: Long,
    val artistName: String?,
    val collectionName: String?,
    val trackName:String?,
    val collectionType:String?,
    val collectionCensoredName: String?,
    val artistViewUrl: String?,
    val collectionViewUrl: String?,
    val artworkUrl30: String?,
    val artworkUrl60: String?,
    val artworkUrl100: String?,
    val collectionPrice: Double,
    val collectionExplicitness: String?,
    val copyright: String?,
    val country: String?,
    val currency: String?,
    val releaseDate: String?,
    val primaryGenreName: String?,
    val previewUrl:String?
)
fun AlbumEntity.toAlbum() = Album(
    wrapperType=wrapperType,
    artistId = artistId,
    collectionId = collectionId,
    artistName = artistName,
    collectionName = collectionName,
    trackName = trackName,
    collectionType = collectionType,
    collectionCensoredName = collectionCensoredName,
    artistViewUrl = artistViewUrl,
    collectionViewUrl = collectionViewUrl,
    artworkUrl30 = artworkUrl30,
    artworkUrl60 = artworkUrl60,
    artworkUrl100 = artworkUrl100,
    collectionPrice = collectionPrice,
    collectionExplicitness = collectionExplicitness,
    trackCount = trackCount,
    copyright = copyright,
    country = country,
    currency = currency,
    releaseDate = releaseDate,
    primaryGenreName = primaryGenreName,
    previewUrl = previewUrl,
    isPlaying = false,
    isPaused = false

)