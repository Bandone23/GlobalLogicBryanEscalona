package com.bancosantander.globallogicbryanescalona.presentation.ui.fragment.search

import android.net.ConnectivityManager
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
import com.bancosantander.core.extension.isNetworkAvailable
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.bancosantander.globallogicbryanescalona.R
import com.bancosantander.globallogicbryanescalona.databinding.FragmentSearchBinding
import com.bancosantander.globallogicbryanescalona.domain.model.SongList
import com.bancosantander.globallogicbryanescalona.presentation.ui.fragment.search.SearchFragmentDirections.Companion.nextAction
import com.bancosantander.globallogicbryanescalona.util.AppPreferences
import com.google.android.material.snackbar.Snackbar
import org.koin.android.ext.android.inject

class SearchFragment : Fragment() {
    private val viewModel: SearchViewModel by viewModel()

    private val connectionManager: ConnectivityManager by inject()

    lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.initAdapter { song: SongList, viewId: Int -> songClicked(song, viewId) }
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        val layoutManger = (LinearLayoutManager(activity, RecyclerView.VERTICAL, false))
        binding.recyclerSongs.layoutManager = layoutManger

        with(viewModel) {
            observe(songLiveData, ::songObserver)
            observe(songLocalLiveData, ::songObserver)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (connectionManager.isNetworkAvailable()) {
            binding.tInputSearch.hint = "Busca por artista."
        } else {
            binding.tInputSearch.hint = "Sin Conexion ultimos Resultados. "
            viewModel.getLocalSong(term = AppPreferences.searchItem.toString())

        }
        binding.imageButtonSearch.setOnClickListener {
            AppPreferences.searchItem = binding.tInputSearch.text.toString()

            if (connectionManager.isNetworkAvailable()) {
                viewModel.getSong(term = binding.tInputSearch.text.toString())
            } else {
                binding.tInputSearch.hint = "Presiona Buscar para ver tus ultimos Resultados. "
                viewModel.getLocalSong(term = AppPreferences.searchItem.toString())

            }

        }


    }


    private fun songObserver(result: Result<List<SongList>>?) {
        when (result) {
            is Result.OnLoading -> {
                binding.pBarSearch.visibility = View.VISIBLE
                binding.recyclerSongs.visibility = View.GONE
            }
            is Result.OnSuccess -> {
                if (result.value.isNotEmpty()) {
                    binding.pBarSearch.visibility = View.GONE
                    viewModel.updateSong(result.value)
                    binding.recyclerSongs.visibility = View.VISIBLE

                } else {
                    view?.let {
                        Snackbar.make(it, "no se  cargados los datos", Snackbar.LENGTH_LONG).show()
                    }
                }

                if (connectionManager.isNetworkAvailable()) {
                    view?.let {
                        Snackbar.make(
                            it,
                            "datos cargados correctamente.",
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                } else {
                    view?.let {
                        Snackbar.make(
                            it,
                            "datos cargados correctamente sin conexion.",
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                }


            }
            is Result.OnError -> {
                binding.pBarSearch.visibility = View.GONE
                if (!connectionManager.isNetworkAvailable()) {
                    view?.let {
                        Snackbar.make(
                            it,
                            "¿Estás conectado a internet?",
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                }
            }
            is Result.OnCancel -> {
            }
            else -> {
            }
        }
    }


    private fun songClicked(song: SongList, viewId: Int) {
        when (viewId) {
            R.id.card_song -> {
                val action = nextAction(song.artistId, song.collectionId)
                findNavController().navigate(action)

            }
        }
    }

}
