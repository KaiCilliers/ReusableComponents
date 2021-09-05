package com.example.reusablecomponents.staging.mvi

import kotlinx.coroutines.flow.Flow

interface ViewEvent
interface MviState
interface MviPartialState<S: MviState> {
    fun reduce(previousState: S): S
}
interface MviEvent
interface MviAction

interface MviView<T: ViewEvent> {
    fun viewEvents(): Flow<T>
}

data class FooState(val one: Boolean, val two: Boolean, val data: List<String>): MviState

sealed interface FooPartialState : MviPartialState<FooState> {
    object Loading : FooPartialState {
        override fun reduce(previousState: FooState): FooState {
            return previousState.copy(one = true)
        }
    }
    data class SearchResults(val data: List<String>) : FooPartialState {
        override fun reduce(previousState: FooState): FooState {
            return previousState.copy(data = data)
        }

    }
}

// todo base classes