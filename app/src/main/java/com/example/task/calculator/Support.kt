package com.example.task.calculator

fun getNewNumber(nowNumber: String, newDigitOrComma: String): String {
    var resultNumber = nowNumber
    when (newDigitOrComma) {
        in "0".."9" ->
            if (resultNumber != "0") {
                resultNumber += newDigitOrComma }
            else {
                resultNumber = newDigitOrComma
            }
        "," ->
            if (resultNumber.isNotEmpty() && !resultNumber.contains(".")) {
                resultNumber += "."
            }
    }

    return resultNumber
}

fun changeSign(nowNumber: String): String{
    return if (nowNumber.contains("-")){
        nowNumber.replace("-","")
    } else {
        "-$nowNumber"
    }
}

fun getDisplayContent(nowNumber: String, suppOperation: String): String{
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
