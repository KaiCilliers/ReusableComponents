package com.example.reusablecomponents.staging.constants

import kotlin.random.Random

class Some {

    class Builder() {
        fun add(int: Int): Builder {
            cool(int, 888, 9292, 5)
            return this
        }

        private val i3 = 4

        private fun cool(int: Int, i1: Int, peter: Int, i2: Int) {
            val okkkk = mutableMapOf<String, String>()
            val s = int
            val i = i1
            val ok = peter
            val max = i3 + -i2
            val peep = i
        }
    }
}

fun main() {
    val s = Random(9).nextInt()
    val ss = Some.Builder().add(3)
}
