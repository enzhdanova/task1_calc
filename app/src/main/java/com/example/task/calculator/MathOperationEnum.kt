package com.example.task.calculator

enum class MathOperationEnum(val operation: String) {
    Div("/"),
    Mult("*"),
    Sub("-"),
    Add("+"),
    Equals("=")
}

enum class SupportOperationEnum(val operation: String) {
    AC("AC"),
    Sign("+/-"),
    Percent("%")
}