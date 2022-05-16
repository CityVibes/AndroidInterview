package com.radio.jams

import kotlinx.serialization.Serializable

@Serializable
class GitRepository(
    val id: Long,
    val full_name: String,
)