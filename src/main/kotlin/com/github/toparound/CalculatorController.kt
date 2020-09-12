package com.github.toparound

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CalculatorController {

    val calculator: Calculator = Calculator()

    val converter: Converter = Converter()

    @GetMapping("/calculate")
    fun calculate(@RequestParam("exp") expression: String): String {
        return calculator.calculateResult(converter.convertToRPN(expression)).toString()
    }
}