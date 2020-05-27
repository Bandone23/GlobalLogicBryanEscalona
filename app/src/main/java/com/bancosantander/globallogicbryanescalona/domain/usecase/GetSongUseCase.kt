package com.bancosantander.globallogicbryanescalona.domain.usecase

import com.bancosantander.core.coroutines.ResultUnitUseCase
import com.bancosantander.globallogicbryanescalona.data.repository.SongRepository
import com.bancosantander.globallogicbryanescalona.domain.model.SongList
import kotlinx.coroutines.Dispatchers

class GetSongUseCase (
    private val repository: SongRepository
): ResultUnitUseCase<List<SongList>>(
    backgroundContext = Dispatchers.IO,
    foregroundContext = Dispatchers.Main
) {
    override suspend fun executeOnBackground(): List<SongList>? {
        return repository.getSong()
    }
}