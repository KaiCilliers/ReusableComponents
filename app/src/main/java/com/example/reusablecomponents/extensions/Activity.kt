package com.example.reusablecomponents.extensions

import androidx.appcompat.app.AppCompatActivity

/**
 * Usage
 *   val firstName by getValue<String>("firstName") // String?
 */
// Bundle access nullable
inline fun <reified  T : Any> AppCompatActivity.getValue(
    label : String, defaultvalue : T? = null) = lazy{
    val value = intent?.extras?.get(label)
    if (value is T) value else defaultvalue
}

// Bundle access non-nullable
inline fun <reified  T : Any> AppCompatActivity.getValueNonNull(
    label : String, defaultvalue : T? = null) = lazy{
    val value = intent?.extras?.get(label)
    requireNotNull((if (value is T) value else defaultvalue)){label}
}