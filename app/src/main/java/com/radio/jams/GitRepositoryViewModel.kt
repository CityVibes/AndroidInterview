package com.radio.jams

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class GitRepositoryViewModel(private val githubApi: GithubApi): ViewModel() {
    private val _repositories: MutableLiveData<List<GitRepository>> = MutableLiveData()
    val repository: LiveData<List<GitRepository>> = _repositories

    fun fetchRepositories() {
        viewModelScope.launch {
            val repos = githubApi.fetchRepositories()
            _repositories.value = repos
        }
    }
}