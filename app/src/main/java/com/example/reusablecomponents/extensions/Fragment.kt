package com.example.reusablecomponents.extensions

import androidx.fragment.app.Fragment

/**
 * Usage
 *   val firstName by getValue<String>("firstName") // String?
 */
// Bundle access nullable
inline fun <reified T: Any> Fragment.getValue(label: String, defaultvalue: T? = null) = lazy {
    val value = arguments?.get(label)
    if (value is T) value else defaultvalue
}

// Bundle access non-nullable
inline fun <reified T: Any> Fragment.getValueNonNull(label: String, defaultvalue: T? = null) = lazy {
    val value = arguments?.get(label)
    requireNotNull(if (value is T) value else defaultvalue) { label }
}