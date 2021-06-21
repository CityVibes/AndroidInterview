package com.radio.jams

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@OptIn(ExperimentalPagingApi::class)
class GitRemoteMediator(private val api: GithubApi, private val dao: GitDao) :
    RemoteMediator<Int, GitRepository>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, GitRepository>
    ): MediatorResult {
        val lastId = state.lastItemOrNull()?.id

        return withContext(Dispatchers.IO) {
            try {
                val results = api.fetchRepositories(lastId)

                dao.insertRepositories(results)

                val endOfPaginationReached = results.isEmpty()
                MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
            } catch (exception: Exception) {
                MediatorResult.Error(exception)
            }
        }
    }
}
