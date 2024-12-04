package com.seenu.dev.meme_creator.data.repository

import com.seenu.dev.meme_creator.data.dao.MemeDao
import com.seenu.dev.meme_creator.domain.model.Meme
import com.seenu.dev.meme_creator.domain.repository.MemeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MemeRepositoryImpl @Inject constructor(
    private val memeDao: MemeDao
) : MemeRepository {

    override fun getMemes(): Flow<List<Meme>> {
        return memeDao.getMemes()
    }

    override suspend fun insertMeme(meme: Meme) {
        return memeDao.insertMeme(meme)
    }

    override suspend fun deleteMeme(meme: Meme) {
        return memeDao.deleteMeme(meme)
    }

}