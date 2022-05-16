package com.radio.jams

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class GithubRepositoryViewModel(val api: GithubApi): ViewModel() {

    private val gitRepositories: MutableLiveData<List<GitRepository>> by lazy {
        MutableLiveData<List<GitRepository>>().also {
            viewModelScope.launch {
                getRepositoryInfo()
            }
        }
    }

    fun getRepositories(): LiveData<List<GitRepository>> {
        return gitRepositories
    }

    private suspend fun getRepositoryInfo() {
        val gitRepositories = api.fetchRepositories()

    }
}