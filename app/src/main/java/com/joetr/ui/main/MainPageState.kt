package com.joetr.ui.main

sealed class MainPageState {
    object Loading : MainPageState()
    object Error : MainPageState()
    data class Content(val data : List<String>) : MainPageState()
    object Empty : MainPageState()
}
