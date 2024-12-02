package com.seenu.dev.meme_creator.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.seenu.dev.meme_creator.domain.model.Meme
import kotlinx.coroutines.flow.Flow

@Dao
interface MemeDao {

    @Query("Select * FROM meme")
    fun getMemes(): Flow<Meme>

    @Insert
    fun addMeme(meme: Meme)

    @Delete
    fun deleteMeme(meme: Meme)

}