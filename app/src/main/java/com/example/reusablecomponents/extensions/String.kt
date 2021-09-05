package com.example.reusablecomponents.extensions

import android.util.Patterns

// Check is a string is valid based on business logic
fun String?.valid() : Boolean =
    this != null && !this.equals("null", true)
            && this.trim().isNotEmpty()


// Email Validation
fun String.isValidEmail(): Boolean
        = this.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()