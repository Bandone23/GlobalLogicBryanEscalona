package com.bancosantander.globallogicbryanescalona.presentation.ui.fragment.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bancosantander.core.extension.observe
import com.bancosantander.core.coroutines.Result
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.bancosantander.globallogicbryanescalona.R
import com.bancosantander.globallogicbryanescalona.databinding.FragmentSearchBinding
import com.bancosantander.globallogicbryanescalona.domain.model.SongList
import com.bancosantander.globallogicbryanescalona.presentation.ui.fragment.search.SearchFragmentDirections.Companion.nextAction
import com.google.android.material.snackbar.Snackbar

class SearchFragment : Fragment() {
    private val viewModel: SearchViewModel by viewModel()
    lateinit var binding:FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.initAdapter { song: SongList, viewId: Int -> songClicked(song, viewId) }
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        binding.lifecycleOwner =this
        binding.viewModel =viewModel
        val layoutManger = (LinearLayoutManager(activity, RecyclerView.VERTICAL, false))
        binding.recyclerSongs.layoutManager = layoutManger

        with(viewModel) { observe(songLiveData, ::songObserver) }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      binding.imageButtonSearch.setOnClickListener {
          viewModel.getSong(term = binding.tInputSearch.text.toString())
      }


    }


    private fun songObserver(result: Result<List<SongList>>?) {
        when (result) {
            is Result.OnLoading -> {
                binding.pBarSearch.visibility =View.VISIBLE
                binding.recyclerSongs.visibility =View.GONE
            }
            is Result.OnSuccess -> {
                if (result.value.isNotEmpty()) {
                    binding.pBarSearch.visibility =View.GONE
                    viewModel.updateSong(result.value)
                    binding.recyclerSongs.visibility =View.VISIBLE


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
                val action= nextAction(song.artistId,song.collectionId)
                findNavController().navigate(action)

            }
        }
    }

}
