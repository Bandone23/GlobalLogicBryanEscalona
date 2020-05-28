package com.bancosantander.globallogicbryanescalona.data.remote.model

import com.bancosantander.globallogicbryanescalona.domain.model.Album

data class AlbumEntry(
    val wrapperType: String?,
    val artistId: Long,
    val collectionId: Long,
    val artistName: String,
    val collectionName: String?,
    val trackName:String?,
    val collectionType:String?,
    val collectionCensoredName: String,
    val artistViewUrl: String?,
    val collectionViewUrl: String,
    val artworkUrl30: String?,
    val artworkUrl60: String?,
    val artworkUrl100: String?,
    val collectionPrice: Double,
    val collectionExplicitness: String,
    val trackCount: Int,
    val copyright: String,
    val country: String,
    val currency: String,
    val releaseDate: String,
    val primaryGenreName: String,
    val previewUrl:String?
)

fun AlbumEntry.toAlbum() = Album(
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