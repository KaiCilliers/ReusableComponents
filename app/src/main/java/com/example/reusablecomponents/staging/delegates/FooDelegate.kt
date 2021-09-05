package com.example.reusablecomponents.staging.delegates

import kotlin.reflect.KProperty

class HundredDelegate {
    var value = 0
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return value
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        this.value = value * 100
    }
}

class Example {
    var cool: Int by HundredDelegate()
    fun main() {
        println(cool)
        cool = 44
        println(cool)
    }
}