package com.ceph.pagination

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.paging.compose.collectAsLazyPagingItems
import com.ceph.pagination.presentation.BeerScreen
import com.ceph.pagination.presentation.BeerViewModel
import com.ceph.pagination.ui.theme.PaginationTheme
import org.koin.androidx.compose.koinViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PaginationTheme {

                val viewModel = koinViewModel<BeerViewModel>()
                val beers = viewModel.beers.collectAsLazyPagingItems()

                BeerScreen(beers = beers)


            }
        }
    }
}

