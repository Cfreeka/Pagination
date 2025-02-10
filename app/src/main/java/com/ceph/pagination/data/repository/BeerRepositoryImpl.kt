package com.ceph.pagination.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.ceph.pagination.data.local.BeerDatabase
import com.ceph.pagination.data.mappers.toBeer
import com.ceph.pagination.data.paging.BeerRemoteMediator
import com.ceph.pagination.data.remote.BeerApi
import com.ceph.pagination.domain.model.Beer
import com.ceph.pagination.domain.repository.BeerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class BeerRepositoryImpl(
    private val database: BeerDatabase,
    private val beerApi: BeerApi
) : BeerRepository {

    private val dao = database.dao
    @OptIn(ExperimentalPagingApi::class)
    override fun getBeers(): Flow<PagingData<Beer>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = BeerRemoteMediator(database, beerApi = beerApi),
            pagingSourceFactory = {
                dao.pagingSource()
            }
        ).flow
            .map { pagingData ->
                pagingData.map { it.toBeer() }
            }
    }
}