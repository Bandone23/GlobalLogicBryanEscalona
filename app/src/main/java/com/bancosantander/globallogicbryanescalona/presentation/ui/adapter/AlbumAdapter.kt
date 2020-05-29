package com.bancosantander.globallogicbryanescalona.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bancosantander.globallogicbryanescalona.R
import com.bancosantander.globallogicbryanescalona.databinding.ItemSongAlbumBinding
import com.bancosantander.globallogicbryanescalona.domain.model.Album
import com.bancosantander.globallogicbryanescalona.presentation.ui.adapter.holder.AlbumHolder

class AlbumAdapter(
    private var songAlbum: MutableList<Album>,
    private val clickListener: (Album, Int) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val itemBinding: ItemSongAlbumBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_song_album,
                parent,
                false
            )
        return AlbumHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return songAlbum.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = songAlbum[position]
        holder as AlbumHolder
        holder.bindEvent(item,clickListener)
    }

    fun setData(songList: List<Album>) {
        if (songAlbum.isNullOrEmpty()) {
            songAlbum = songList.toMutableList()
        }else {
            songAlbum.clear()
            songAlbum.addAll(songAlbum.size,songList)
        }

        notifyDataSetChanged()
    }

}