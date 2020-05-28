package com.bancosantander.globallogicbryanescalona.presentation.ui.fragment.detail

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bancosantander.core.coroutines.Result
import com.bancosantander.core.extension.observe

import com.bancosantander.globallogicbryanescalona.R
import com.bancosantander.globallogicbryanescalona.databinding.FragmentAlbumBinding
import com.bancosantander.globallogicbryanescalona.domain.model.Album
import com.bancosantander.globallogicbryanescalona.util.getImgPicasso
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class AlbumFragment : Fragment() {

    private val viewModel:AlbumViewModel by viewModel()
    lateinit var binding: FragmentAlbumBinding
    private val mediaPlayer = MediaPlayer()

    private var artistId: Long = 0
    private var collectionId: Long = 0
    private val songListAlbum: MutableList<Album> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        artistId = AlbumFragmentArgs.fromBundle(requireArguments()).artistId
        collectionId =AlbumFragmentArgs.fromBundle(requireArguments()).collectionId
        Log.d("artistId", " lo que llega $artistId")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.initAdapter { songAlbum: Album, viewId: Int -> songClicked(songAlbum, viewId) }
        binding = FragmentAlbumBinding.inflate(inflater, container, false)
        binding.lifecycleOwner =this
        binding.viewModel =viewModel
        val layoutManger = (LinearLayoutManager(activity, RecyclerView.VERTICAL, false))
        binding.recyclerSongsAlbum.layoutManager = layoutManger
        with(viewModel) { observe(albumLiveData, ::albumObserver) }
        viewModel.getAlbum(collectionId)
        return binding.root
    }

    private fun albumObserver(result: Result<List<Album>>?) {
        when (result) {
            is Result.OnLoading -> { }
            is Result.OnSuccess -> {
                if (result.value.isNotEmpty()) {
                    for ((index,item) in result.value.withIndex()){
                        if (result.value[index].collectionId ==collectionId &&  result.value[index].wrapperType.equals("collection") ){
                            getImgPicasso(result.value[index].artworkUrl100!!,binding.imgAlbum)
                            binding.nameAlbum.text = result.value[index].collectionName
                            binding.collectionType.text =result.value[index].collectionType
                        }else  { songListAlbum.add(result.value[index]) }
                    }
                    viewModel.updateSong(songListAlbum)
                    view?.let { Snackbar.make(it,"datos cargados correctamente", Snackbar.LENGTH_LONG).show() }
                } else {
                    view?.let { Snackbar.make(it,"no se  cargados los datos", Snackbar.LENGTH_LONG).show() }
                }
            }
            is Result.OnError -> { }
            is Result.OnCancel -> { }
            else -> { }
        }
    }


    private fun songClicked(song: Album, viewId: Int) {
        when (viewId) {
            R.id.song_album -> {
               //
            }
            R.id.btn_play->{
                prepareMusicSource(song.previewUrl!!)
                if(mediaPlayer.isPlaying){
                    mediaPlayer.pause();
                   // R.id.btn_play.setImageResource(R.drawable.ic_pause)
                }else{
                    mediaPlayer.start()
                  //  binding.btnPlay.setImageResource(R.drawable.ic_play_on)
                }
            }
        }
    }

    private fun prepareMusicSource(url:String){
       mediaPlayer.setDataSource(url)
        mediaPlayer.prepare()

    }
}
