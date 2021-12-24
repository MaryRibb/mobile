package com.example.lesson3

class Calculator {


    companion object {

        var num1: Double? = null
        var num2: Double? = null
        var operation: String = ""

        fun calculate(): String? {
            var res: Double? = null
            if (num1 != null && num2 != null) {
                when (operation) {
                    "+" -> res = num1!! + num2!!
                    "-" -> res = num1!! - num2!!
                    "*" -> res = num1!! * num2!!
                    "/" -> res = num1!! / num2!!
                }
            }
            return res.toString()
        }
    }
}


