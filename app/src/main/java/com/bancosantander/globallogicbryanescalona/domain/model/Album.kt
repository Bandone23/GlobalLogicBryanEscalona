package com.bancosantander.globallogicbryanescalona.domain.model

import com.bancosantander.globallogicbryanescalona.R

data class Album (
    val wrapperType: String?,
    val artistId: Long,
    val collectionId: Long,
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
    val trackCount: Int,
    val copyright: String?,
    val country: String?,
    val currency: String?,
    val releaseDate: String?,
    val primaryGenreName: String?,
    val previewUrl:String?,
    var isPlaying: Boolean,
    var isPaused: Boolean
) {
    fun computeActionIconResource() = when {
        isPlaying -> R.drawable.ic_pause
        isPaused -> R.drawable.ic_play_on

        else -> 0
    }
}