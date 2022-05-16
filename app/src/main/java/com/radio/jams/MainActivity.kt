package com.radio.jams

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    private val githubReposViewModel by viewModels<GithubRepositoryViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        githubReposViewModel.getRepositories().observe(this, Observer { repositories ->
            Log.d("Github", repositories.toString())
        })
    }
}
