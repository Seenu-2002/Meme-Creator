package com.seenu.dev.meme_creator.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.seenu.dev.meme_creator.data.dao.MemeDao
import com.seenu.dev.meme_creator.domain.model.Meme

@Database(
    entities = [Meme::class],
    version = 1
)
abstract class MemeDatabase : RoomDatabase() {

    abstract val memeDao: MemeDao

    companion object {
        const val DB_NAME = "meme_db"
    }

}