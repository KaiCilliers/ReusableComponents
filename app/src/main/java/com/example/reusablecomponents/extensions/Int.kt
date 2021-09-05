package com.example.reusablecomponents.extensions

import android.app.Application
import androidx.core.content.ContextCompat


// More concise way to fetch colors and drawables, just fetch application context
// fun Int.asColor() = ContextCompat.getColor(ApplicationClass.instance, this)
// fun Int.asDrawable() = ContextCompat.getDrawable(MavrikApplication.instance, this)

//Usage at call site
// val color = R.color.dark_blie.asColor()
// val drawable = R.drawable.launcher.asDrawable()