package com.example.task.calculator

object CalcScreen {
        // Sample conversation data
        val calcFun = listOf(
            CalcContent("AC"),
            CalcContent("+/-"),
            CalcContent("%"),
            )
        val numbers = listOf(
                listOf(
                    CalcContent("7"),
                    CalcContent("8"),
                    CalcContent("9")),
                listOf(
                    CalcContent("4"),
                    CalcContent("5"),
                    CalcContent("6")),
                listOf(
                    CalcContent("1"),
                    CalcContent("2"),
                    CalcContent("3") ),
                listOf(
                    CalcContent("0"),
                    CalcContent(","))
        )

    val mathOperations = listOf(
        CalcContent("/"),
        CalcContent("*"),
        CalcContent("-"),
        CalcContent("+"),
        CalcContent("=")
    )
}

data class CalcContent( val title: String)

data class OpMath(val operationMath: () -> Double)

fun printNumbers(){

}