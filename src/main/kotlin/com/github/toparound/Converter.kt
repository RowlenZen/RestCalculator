package com.github.toparound

class Converter() {

    fun convertToRPN(expression: String): List<String> {
        val exitStr: MutableList<String> = mutableListOf()
        val stack: MutableList<Char> = mutableListOf()
        var i = 0
        while (i < expression.length) {
            when (expression[i]) {
                '!' -> exitStr.add(expression[i].toString())
                '(' -> stack.add(expression[i])
                in '0'..'9' -> {
                    var number = Character.getNumericValue(expression[i])
                    if (i + 1 < expression.length) {
                        while (expression[i + 1] in '0'..'9') {
                            number = number * 10 + Character.getNumericValue(expression[i+1])
                            i++
                            if (i+1 == expression.length) break
                        }
                        exitStr.add(number.toString())
                    } else {
                        exitStr.add(number.toString())
                    }
                }
                '+', '-', '*', '/' -> {
                    if (stack.size == 0) {
                        stack.add(expression[i])
                    } else if (stack[stack.size - 1] == '+' || stack[stack.size - 1] == '-') {
                        if (expression[i] == '*' || expression[i] == '/') {
                            stack.add(expression[i])
                        } else {
                            exitStr.add(stack[stack.size - 1].toString())
                            stack[stack.size - 1] = expression[i]
                        }
                    } else {
                        if (stack[stack.size - 1] == '*' || stack[stack.size - 1] == '/') {
                            exitStr.add(stack[stack.size - 1].toString())
                            stack[stack.size - 1] = expression[i]
                        } else {
                            stack.add(expression[i])
                        }
                    }
                }
                ')' -> {
                    while (stack[stack.size - 1] != '(') {
                        exitStr.add(stack[stack.size - 1].toString())
                        stack.removeAt(stack.size - 1)
                    }
                    stack.removeAt(stack.size - 1)
                }
            }
            i++
        }
        for (k in (stack.size - 1) downTo 0) {
            exitStr.add(stack[k].toString())
            stack.removeAt(k)
        }
        return exitStr
    }
}