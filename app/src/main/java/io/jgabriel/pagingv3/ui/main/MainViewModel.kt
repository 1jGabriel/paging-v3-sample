package io.jgabriel.pagingv3.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import io.jgabriel.pagingv3.RickNMortyApi
import io.jgabriel.pagingv3.model.CharacterResult
import io.jgabriel.pagingv3.repository.MyPagingSource
import kotlinx.coroutines.flow.Flow

class MainViewModel(private val api : RickNMortyApi) : ViewModel() {
    fun getItems(): Flow<PagingData<CharacterResult.Character>> {
        return Pager(
            config = PagingConfig(pageSize = 20, maxSize = 500),
            pagingSourceFactory = { MyPagingSource(api) }
        ).flow.cachedIn(viewModelScope)
    }
}
