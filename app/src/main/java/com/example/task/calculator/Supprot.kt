package com.example.task.calculator

fun getResultMathOperation(value1: String, value2: String, mathOperation: String): String{
    val tmp = if (value2 != "") {value2.toDouble()} else {0.0}
    var result = value1.toDouble()
    when (mathOperation) {
        "+" -> {
            result +=tmp
        }
        "-" -> {
            result -=tmp
        }
        "*" -> {
            result *=tmp
        }
        "/" -> {
            result /=tmp
        }
    }
    return result.toString()
}

fun checkAndReturnResult(nowMathOperation: String, result: String): CalcState{
    return if (nowMathOperation == "=") {
        CalcState(tmp = result, result = "0", mathOperation = "+")
    } else {
        CalcState(tmp = "", result = result, mathOperation = nowMathOperation)
    }
}

