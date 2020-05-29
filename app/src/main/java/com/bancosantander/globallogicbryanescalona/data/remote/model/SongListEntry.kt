package com.bancosantander.globallogicbryanescalona.data.remote.model

import com.bancosantander.globallogicbryanescalona.domain.model.SongList

data class SongListEntry (
    val wrapperType:String,
    val kind:String,
    val artistId:Long,
    val collectionId:Long,
    val trackId:Long,
    val artistName:String,
    val collectionName:String,
    val trackName:String,
    val collectionCensoredName:String,
    val trackCensoredName:String,
    val artistViewUrl:String,
    val collectionViewUrl:String,
    val trackViewUrl:String,
    val previewUrl:String,
    val artworkUrl30:String,
    val artworkUrl60:String,
    val artworkUrl100:String,
    val collectionPrice:Float,
    val trackPrice:Float,
    val releaseDate:String,
    val collectionExplicitness:String,
    val trackExplicitness:String,
    val discCount:Int,
    val discNumber:Int,
    val trackCount:Int,
    val trackNumber:Int,
    val trackTimeMillis:Int,
    val country:String,
    val currency:String,
    val primaryGenreName:String,
    val isStreamable:Boolean

)
fun SongListEntry.toSongs() = SongList (
    wrapperType =wrapperType,
    kind=kind,
    artistId=artistId,
    collectionId=collectionId,
    trackId=trackId,
    artistName=artistName,
    collectionName=collectionName,
    trackName=trackName,
    collectionCensoredName=collectionCensoredName,
    trackCensoredName=trackCensoredName,
    artistViewUrl=artistViewUrl,
    collectionViewUrl=collectionViewUrl,
    trackViewUrl=trackViewUrl,
    previewUrl=previewUrl,
    artworkUrl30=artworkUrl30,
    artworkUrl60=artworkUrl60,
    artworkUrl100=artworkUrl100,
    collectionPrice=collectionPrice,
    trackPrice=trackPrice,
    releaseDate=releaseDate,
    collectionExplicitness=collectionExplicitness,
    trackExplicitness=trackExplicitness,
    discCount=discCount,
    discNumber=discNumber,
    trackCount=trackCount,
    trackNumber=trackNumber,
    trackTimeMillis=trackTimeMillis,
    country=country,
    currency=currency,
    primaryGenreName=primaryGenreName,
    isStreamable=isStreamable

)


