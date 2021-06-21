package com.radio.jams

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn

class GitViewModel(
    private val dao: GitDao,
    private val mediator: GitRemoteMediator
) : ViewModel() {

    private val pagingSourceFactory = { dao.getAllRepositories() }

    @OptIn(ExperimentalPagingApi::class)
    fun repositories() = Pager(
        config = PagingConfig(pageSize = 20),
        remoteMediator = mediator,
        pagingSourceFactory = pagingSourceFactory
    ).flow.cachedIn(viewModelScope)
}
