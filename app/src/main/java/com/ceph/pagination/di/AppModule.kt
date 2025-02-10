package com.ceph.pagination.di

import androidx.room.Room
import com.ceph.pagination.data.local.BeerDatabase
import com.ceph.pagination.data.remote.BeerApi
import com.ceph.pagination.data.repository.BeerRepositoryImpl
import com.ceph.pagination.domain.repository.BeerRepository
import com.ceph.pagination.presentation.BeerViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


val appModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            BeerDatabase::class.java,
            "database-name"
        ).build()
    }

    viewModel { BeerViewModel(get()) }


    single { get<BeerDatabase>().dao }

    single {


        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BeerApi.BASE_URL)
            .build()


    }

    single { get<Retrofit>().create(BeerApi::class.java) }

    single { BeerRepositoryImpl(get(),get()) } bind BeerRepository::class

}