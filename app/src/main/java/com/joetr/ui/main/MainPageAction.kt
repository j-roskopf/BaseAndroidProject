package com.joetr.ui.main


sealed class MainPageAction {
    object GetAll : MainPageAction()
    data class ItemClicked(val id: String) : MainPageAction()
}

typealias MainPageActionHandler = (MainPageAction) -> Unit