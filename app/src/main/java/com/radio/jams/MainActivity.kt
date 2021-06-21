package com.radio.jams

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.radio.jams.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: GitViewModel by viewModel<GitViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.gitList.apply {
            adapter = GitAdapter()
            layoutManager = LinearLayoutManager(context)
        }

        lifecycleScope.launch {
            viewModel.repositories()
                .flowOn(Dispatchers.IO)
                .collectLatest {
                    (mainBinding.gitList.adapter as GitAdapter).submitData(it)
                }
        }
    }
}
