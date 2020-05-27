package com.bancosantander.globallogicbryanescalona.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bancosantander.globallogicbryanescalona.R
import com.bancosantander.globallogicbryanescalona.databinding.ItemSongBinding
import com.bancosantander.globallogicbryanescalona.domain.model.SongList
import com.bancosantander.globallogicbryanescalona.presentation.ui.adapter.holder.SongHolder


class SongAdapter(
    private var song: MutableList<SongList>,
    private val clickListener: (SongList, Int) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val itemBinding: ItemSongBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_song,
                parent,
                false
            )
        return SongHolder(itemBinding)
    }

    override fun getItemCount(): Int {
       return song.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = song[position]
        holder as SongHolder
        holder.bindEvent(item,clickListener)
    }

    fun setData(songList: List<SongList>) {
        if (song.isNullOrEmpty()) {
            song = songList.toMutableList()
        }else {
            song.clear()
            song.addAll(song.size,songList)
        }

        notifyDataSetChanged()
    }

}