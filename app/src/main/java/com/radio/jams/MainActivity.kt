package com.radio.jams

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val viewModel: GitRepositoryViewModel by inject()
    private val adapter: GitRepositoryAdapter = GitRepositoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<RecyclerView>(R.id.repository_list)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)

        viewModel.fetchRepositories()
        viewModel.repository.observe(this) {
            adapter.setItems(it)
        }
    }
}
