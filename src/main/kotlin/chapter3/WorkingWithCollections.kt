package chapter3

// infix call `to` for maps
val map = mapOf(1 to "one", 2 to "two", /*intentional dot notation*/ 3.to("three"))

data class Test(val a: Int, val b: Int, private val c: Int)

fun main() {
    println(map)
    // destructure a test class into 2 variables; can't destructure private variables, and you can only destructure variables in the constructor
    val (a, b) = Test(1, 2, 3)
    println("a: $a\nb: $b")
}