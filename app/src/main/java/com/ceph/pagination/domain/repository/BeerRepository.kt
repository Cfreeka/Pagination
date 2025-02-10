package com.ceph.pagination.domain.repository

import androidx.paging.PagingData
import com.ceph.pagination.data.dto.BeerDto
import com.ceph.pagination.domain.model.Beer
import kotlinx.coroutines.flow.Flow

interface BeerRepository {

    fun getBeers(): Flow<PagingData<Beer>>
}