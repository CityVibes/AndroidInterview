package com.radio.jams

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = GitDao.repoTable)
@Serializable
class GitRepository(
    @PrimaryKey
    val id: Long,
    val full_name: String,
)