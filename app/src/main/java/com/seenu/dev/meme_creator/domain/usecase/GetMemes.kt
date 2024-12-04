package com.seenu.dev.meme_creator.domain.usecase

import com.seenu.dev.meme_creator.domain.model.Meme
import com.seenu.dev.meme_creator.domain.repository.MemeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class GetMemes @Inject constructor(
    private val repository: MemeRepository
) {

    operator fun invoke(): Flow<List<Meme>> {
        return repository.getMemes().onEach {

        }
    }

}