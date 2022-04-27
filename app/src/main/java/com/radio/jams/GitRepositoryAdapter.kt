package com.radio.jams

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GitRepositoryAdapter: RecyclerView.Adapter<GitRepositoryViewHolder>() {
    private var repositories: List<GitRepository> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitRepositoryViewHolder {
        return GitRepositoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.git_repo_item_list, parent, false))
    }

    override fun onBindViewHolder(holder: GitRepositoryViewHolder, position: Int) {
        val repo = repositories[position]
        holder.bind(repo)
    }

    override fun getItemCount() = repositories.size

    fun setItems(items: List<GitRepository>) {
        repositories = items
        notifyDataSetChanged()
    }
}

class GitRepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val text = itemView.findViewById<TextView>(R.id.repository_name)

    fun bind(repo: GitRepository) {
        text.text = repo.full_name
    }
}