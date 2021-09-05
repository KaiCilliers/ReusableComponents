package com.example.reusablecomponents.staging.constants

class CRLFSuffix(private val origin: String) : CRLFString {
    override fun toString(): String {
        return String.format("%s\r\n", origin)
    }
}

class CRLFPrefix(private val origin: String): CRLFString {
    override fun toString(): String {
        return String.format("\r\n%s", origin)
    }
}

interface CRLFString {
    override fun toString(): String
}