package com.kuba.mealky.presenters

abstract class BasePresenter<T> {

    var view: T? = null

    val isViewAttached: Boolean
        get() = this.view == null

    fun attach(view: T) {
        this.view = view
    }

    fun detach() {
        this.view = null
    }
}