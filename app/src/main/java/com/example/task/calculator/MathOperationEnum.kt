package com.example.task.calculator

enum class MathOperationEnum(val operation: String) {
    Add("+"),
    Sub("-"),
    Mult("*"),
    Div("-"),
    Equals("=")
}

enum class SupportOperationEnum(val operation: String) {
    AC("AC"),
    Sign("+/-"),
    Percent("%")
}