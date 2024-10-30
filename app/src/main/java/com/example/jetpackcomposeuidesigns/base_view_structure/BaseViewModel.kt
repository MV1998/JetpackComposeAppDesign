package com.example.jetpackcomposeuidesigns.base_view_structure

import androidx.lifecycle.ViewModel

abstract class BaseViewModel<State : IViewState, Event : IViewEvent> : ViewModel() {

    private val initialState : State by lazy { createInitialState() }

    abstract fun createInitialState() : State

}

class SplashViewModel : BaseViewModel<SplashViewModel.ViewState, SplashViewModel.ViewEvent>() {

    sealed class ViewEvent : IViewEvent {
        class SetLoading(val state : Boolean) : ViewEvent()
        class SetState(val state : String) : ViewEvent()
    }

    data class ViewState(
        val isLoading : Boolean = false,
        val loginState : String? = null) : IViewState

    override fun createInitialState(): ViewState {
        return ViewState()
    }

}