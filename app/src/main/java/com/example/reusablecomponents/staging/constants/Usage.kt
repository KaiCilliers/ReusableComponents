package com.example.reusablecomponents.staging.constants

class Usage {
    fun main() {
        println("Constants are used ${Constants.CRLF}")

        println("${CRLFSuffix("Class is used")}")

        println("Extension used".CRLFSuffix())

        println("Extracted interface".CRLFPrefix())
    }
}

fun String.CRLFSuffix() = CRLFSuffix(this).toString()
fun String.CRLFPrefix() = CRLFPrefix(this).toString()