package com.example.task.calculator

data class CalcState(
    var result: String = "0",
    var tmp: String = "",
    var mathOperation: String = "+",
)