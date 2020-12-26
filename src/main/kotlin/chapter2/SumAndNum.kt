package chapter2

import kotlin.math.exp

// exercise from the book that involves inheritance and interfaces, as well as dynamic casting

interface Expression
class Num(val value: Int) : Expression
class Sum(val left: Expression, val right: Expression) : Expression

fun eval(expression: Expression): Int {
    // use dynamic cast in a when statement
    return when (expression) {
        is Num -> expression.value
        is Sum -> eval(expression.left) + eval(expression.right)
        else -> throw Exception("unhandled Expression Implementation")
    }
}

fun main() {
    // read lines from the console...normally I would add in type checking and error handling, but this is a learning example so I won't bother
    println("Enter first number:")
    val firstNumber = Num(Integer.parseInt(readLine()))
    println("Enter second number:")
    val secondNumber = Num(Integer.parseInt(readLine()))
    println("Enter third number:")
    val thirdNumber = Num(Integer.parseInt(readLine()))

    print("The sum is ")
    println(eval(Sum(Sum(firstNumber, secondNumber), thirdNumber)))
}