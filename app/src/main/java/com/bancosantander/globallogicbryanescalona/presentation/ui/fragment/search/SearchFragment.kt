package com.bancosantander.globallogicbryanescalona.presentation.ui.fragment.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bancosantander.core.extension.observe
import com.bancosantander.core.coroutines.Result
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.bancosantander.globallogicbryanescalona.R
import com.bancosantander.globallogicbryanescalona.databinding.FragmentSearchBinding
import com.bancosantander.globallogicbryanescalona.domain.model.SongList
import com.google.android.material.snackbar.Snackbar

class SearchFragment : Fragment() {
    private val viewModel: SongViewModel by viewModel()
    lateinit var binding:FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel.initAdapter { song: SongList, viewId: Int -> songClicked(song, viewId) }
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        binding.lifecycleOwner =this
        binding.viewModel =viewModel
        val layoutManger = (LinearLayoutManager(activity, RecyclerView.VERTICAL, false))
        binding.recyclerSongs.layoutManager = layoutManger


        with(viewModel) {
            observe(songLiveData, ::songObserver)

        }

        viewModel.getSong()

        return binding.root
    }


    private fun songObserver(result: Result<List<SongList>>?) {
        when (result) {
            is Result.OnLoading -> { }
            is Result.OnSuccess -> {
                if (result.value.isNotEmpty()) {
                    viewModel.updateSong(result.value)
                    view?.let { Snackbar.make(it,"datos cargados correctamente",Snackbar.LENGTH_LONG).show() }
                } else {
                    view?.let { Snackbar.make(it,"no se  cargados los datos",Snackbar.LENGTH_LONG).show() }
                }
            }
            is Result.OnError -> { }
            is Result.OnCancel -> { }
            else -> { }
        }
    }


    private fun songClicked(song: SongList, viewId: Int) {
        when (viewId) {
            R.id.card_song -> {
               /* val songDetailFragment = SongDetailFragment.newInstance(song.artworkUrl100,song.collectionName,song.trackNumber)
                songDetailFragment.show(fragmentManager!!, "songDetail")*/
            }
        }
    }

}
