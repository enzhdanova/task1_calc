package com.example.task.calculator

class Calculator {
    fun getResultMathOperation(
        value1: String,
        value2: String,
        mathOperation: MathOperationEnum
    ): String {
        val value2Tmp = value2.toDouble()
        var value1Tmp = value1.toDouble()
        when (mathOperation) {
            MathOperationEnum.Add -> {
                value1Tmp += value2Tmp
            }
            MathOperationEnum.Sub -> {
                value1Tmp -= value2Tmp
            }
            MathOperationEnum.Mult -> {
                value1Tmp *= value2Tmp
            }
            MathOperationEnum.Div -> {
                value1Tmp /= value2Tmp
            }
            MathOperationEnum.Equals -> {
                value1Tmp = value2Tmp
            }
        }
        return removeExtraZero(value1Tmp.toString())
    }

    private fun removeExtraZero(value: String): String {
        val regex = Regex(""".+(?=\.0+$)""")

        val matchResult = regex.find(value)
        val result = matchResult?.value ?: value

        println(matchResult?.value)
        return result
    }

    fun getNewNumber(nowNumber: String, newDigitOrComma: String): String {
        var resultNumber = nowNumber
        when (newDigitOrComma) {
            in "0".."9" ->
                if (resultNumber != "0") {
                    resultNumber += newDigitOrComma
                } else {
                    resultNumber = newDigitOrComma
                }
            "," ->
                if (resultNumber.isNotEmpty() && !resultNumber.contains(".")) {
                    resultNumber += "."
                }
        }
        return resultNumber
    }

    private fun changeSign(nowNumber: String): String {
        return if (nowNumber.contains("-")) {
            nowNumber.replace("-", "")
        } else {
            "-$nowNumber"
        }
    }

    fun getDisplayContent(nowNumber: String, suppOperation: String): String {
        var result = ""
        when (suppOperation) {
            "%" -> {
                val tmp = nowNumber.toDouble() / 100
                result = tmp.toString()
            }
            "+/-" -> result = changeSign(nowNumber)
        }
        return result
    }

}