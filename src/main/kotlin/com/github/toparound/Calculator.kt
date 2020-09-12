package com.github.toparound
import java.lang.NumberFormatException

class Calculator() {

    fun calculateResult(stringRPN: List<String>): Int? {
        var a: Int? = null
        var b: Int? = null
        for (i in 0 until stringRPN.size) {
            if (stringRPN[i].isDigit()) {
                if (a == null) {
                    a = stringRPN[i].toInt()
                } else{
                    b = stringRPN[i].toInt()
                }
            } else {
                when (stringRPN[i]) {
                    "+" -> a = a!! + b!!
                    "-" -> a = a!! - b!!
                    "*" -> a = a!! * b!!
                    "/" -> a = a!! / b!!
                }

            }
        }
        return a
    }

    private fun String.isDigit(): Boolean {
        try {
            this.toInt()
            return true
        } catch (e: NumberFormatException) {
            return false
        }
    }

}