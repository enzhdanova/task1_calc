package com.example.task.calculator

data class CalcState(
    var result: String = "0",
    var tmp: String = "",
    var mathOperation: String = "+",
) {
    fun getResultMathOperation(): String{
        val value2 = tmp.toDouble()
        var value1 = result.toDouble()
        when (mathOperation) {
            "+" -> {
                value1 +=value2
            }
            "-" -> {
                value1 -=value2
            }
            "*" -> {
                value1 *=value2
            }
            "/" -> {
                value1 /=value2
            }
        }
        return value1.toString()
    }

    fun returnResultCalcState(nowMathOperation: String, result: String): CalcState{
        return if (nowMathOperation == "=") {
            CalcState(tmp = result, result = "0", mathOperation = "+")
        } else {
            CalcState(tmp = "", result = result, mathOperation = nowMathOperation)
        }
    }

    fun getNewNumber(nowNumber: String): String{
        var newNumber = tmp
        when (nowNumber) {
            in "0".."9" -> if (tmp != "0") { newNumber += nowNumber } else { newNumber = nowNumber}
            "" -> newNumber = nowNumber
            "," -> if (tmp.length >= 1 && !tmp.contains(",")) { newNumber += "."}
        }

        return newNumber
    }

    fun changeSign(): String{
        return if (tmp.contains("-")){
            tmp.replace("-","")
        } else {
            "-$tmp"
        }
    }
}