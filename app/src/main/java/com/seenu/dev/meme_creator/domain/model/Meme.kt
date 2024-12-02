package com.seenu.dev.meme_creator.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Meme constructor(
    @PrimaryKey
    val id: Long,
    val name: String,
    val isLiked: Boolean,
    val path: String?
)