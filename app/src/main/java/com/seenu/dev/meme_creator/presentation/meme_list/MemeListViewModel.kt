package com.seenu.dev.meme_creator.presentation.meme_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seenu.dev.meme_creator.domain.model.Meme
import com.seenu.dev.meme_creator.domain.usecase.GetMemes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MemeListViewModel @Inject constructor(
    private val getMemesUseCase: GetMemes
) : ViewModel() {

    private val _memesList: MutableStateFlow<List<Meme>> = MutableStateFlow(emptyList())
    val memesList: StateFlow<List<Meme>> = _memesList.asStateFlow()

    fun getMemes() {
        getMemesUseCase().onEach {
            _memesList.value = it
        }.launchIn(viewModelScope)
    }

}