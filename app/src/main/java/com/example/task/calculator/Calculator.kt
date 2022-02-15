package com.example.task.calculator

class Calculator {
    fun getResultMathOperation(value1: String, value2: String, mathOperation: String): String{
        val value2Tmp = value2.toDouble()
        var value1Tmp = value1.toDouble()
        when (mathOperation) {
            "+" -> {
                value1Tmp += value2Tmp
            }
            "-" -> {
                value1Tmp -=value2Tmp
            }
            "*" -> {
                value1Tmp *=value2Tmp
            }
            "/" -> {
                value1Tmp /=value2Tmp
            }
        }

        return removeExtraZero(value1Tmp.toString())
    }

    fun removeExtraZero(value: String): String{
        val regex = Regex(""".+(?=\.0+$)""")

        val matchResult = regex.find(value)
        var result = matchResult?.value ?: value

        println(matchResult?.value)
        return  result
    }
}