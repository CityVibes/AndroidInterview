package com.radio.jams

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.RecyclerView
import com.radio.jams.databinding.GitItemBinding

class GitAdapter : PagingDataAdapter<GitRepository, GitAdapter.RepositoryViewHolder>(Diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.git_item, parent, false)
        return RepositoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = GitItemBinding.bind(itemView)

        fun bind(gitRepository: GitRepository) {
            binding.repoName.text = gitRepository.full_name
        }
    }

    object Diff : ItemCallback<GitRepository>() {
        override fun areItemsTheSame(oldItem: GitRepository, newItem: GitRepository): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GitRepository, newItem: GitRepository): Boolean {
            return oldItem == newItem
        }
    }
}
