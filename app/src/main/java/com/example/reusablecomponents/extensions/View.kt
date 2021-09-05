package com.example.reusablecomponents.extensions

import android.view.View

fun View.remove() {
    if (visibility != View.GONE) visibility = View.GONE
}

fun View.show() {
    if (visibility != View.VISIBLE) visibility = View.VISIBLE
}

fun View.hide() {
    if (visibility != View.INVISIBLE) visibility = View.INVISIBLE
}