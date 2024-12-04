package com.seenu.dev.meme_creator.di

import android.content.Context
import androidx.room.Room
import com.seenu.dev.meme_creator.data.dao.MemeDao
import com.seenu.dev.meme_creator.data.data_source.MemeDatabase
import com.seenu.dev.meme_creator.data.repository.MemeRepositoryImpl
import com.seenu.dev.meme_creator.domain.repository.MemeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesRepository(dao: MemeDao): MemeRepository {
        return MemeRepositoryImpl(dao)
    }

    @Provides
    @Singleton
    fun providesMemeDao(database: MemeDatabase): MemeDao {
        return database.memeDao
    }

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): MemeDatabase {
        return Room.databaseBuilder(
            context,
            MemeDatabase::class.java,
            MemeDatabase.DB_NAME
        ).build()
    }

}