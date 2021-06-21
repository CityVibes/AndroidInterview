package com.radio.jams

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface GithubApi {

    @GET("https://api.github.com/repositories")
    @Headers("accept: application/vnd.github.v3+json")
    suspend fun fetchRepositories(@Query("since") since: Long? = null): List<GitRepository>
}