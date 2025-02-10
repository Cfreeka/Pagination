package com.ceph.pagination.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.ceph.pagination.data.repository.BeerRepositoryImpl
import com.ceph.pagination.domain.model.Beer
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn


class BeerViewModel(
    private val repository: BeerRepositoryImpl
) : ViewModel() {

    val beers: StateFlow<PagingData<Beer>> = repository.getBeers()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            PagingData.empty()
        )
}