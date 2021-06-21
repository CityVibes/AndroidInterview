package com.radio.jams

import androidx.paging.PagingSource
import androidx.room.*

@Dao
interface GitDao {

    companion object {
        const val repoTable = "repositoryTable"
    }

    @Query("SELECT * FROM $repoTable where id = :id")
    fun getById(id: Int): GitRepository?

    @Query("SELECT * FROM $repoTable")
    fun getAllRepositories(): PagingSource<Int, GitRepository>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRepositories(gitRepositories: List<GitRepository>)

    @Delete
    fun deleteRepository(gitRepository: GitRepository)
}
