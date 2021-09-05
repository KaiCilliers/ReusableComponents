package com.example.reusablecomponents.staging.genericcovariance

import android.view.View
import android.widget.Button
import android.widget.TextView

// https://blog.devgenius.io/kotlin-sealed-class-with-generic-covariance-7e33875e7002
// TODO i am trying to treat each class in sealed as the type they are, i.e. button or textview
class SealedClassWithGenerics {
    fun <T: View>provide(): ViewType<in T> {
        TODO()
    }
}


fun main() {
    val mainone = SealedClassWithGenerics()
    val s = mainone.provide<View>()
    when(s) {
        is ViewType.Button -> {
//            s.button.text
        }
        is ViewType.TextView -> {

        }
    }
}

sealed class ViewType<in T: View> {
    class TextView<T: android.widget.TextView>( val textView: T) : ViewType<T>()
    class Button<T: android.widget.Button>( val button: T) : ViewType<T>()
}

sealed class Event<out T: Any> {
    data class Success<out T: Any>(val value: T): Event<T>()
    data class Error(val msg: String): Event<Nothing>()
}