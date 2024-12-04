package com.seenu.dev.meme_creator.domain.repository

import com.seenu.dev.meme_creator.domain.model.Meme
import kotlinx.coroutines.flow.Flow

interface MemeRepository {

    fun getMemes(): Flow<List<Meme>>

    suspend fun insertMeme(meme: Meme)

    suspend fun deleteMeme(meme: Meme)

}