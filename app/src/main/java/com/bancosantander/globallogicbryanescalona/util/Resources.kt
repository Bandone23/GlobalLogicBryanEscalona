package com.bancosantander.globallogicbryanescalona.util

import android.widget.ImageView
import com.bancosantander.globallogicbryanescalona.R
import com.squareup.picasso.Picasso

fun getImgPicasso(picture: String, view: ImageView?) {
    if (picture.isNotEmpty()) {
        Picasso.get()
            .load(picture)
            .error(R.drawable.ic_music)
            .into(view)
    } else {
        Picasso.get()
            .load(R.drawable.ic_music)
            .error(R.drawable.ic_music)
            .into(view)
    }
}