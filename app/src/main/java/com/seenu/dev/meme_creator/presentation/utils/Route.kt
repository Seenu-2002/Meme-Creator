package com.seenu.dev.meme_creator.presentation.utils

sealed class Route(val name: String) {
    data object MemeList : Route("MemeList")
    data object MemeEdit : Route("MemeEdit")
}