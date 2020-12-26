package chapter2

import java.util.*

// learning the different kotlin loops

fun whileLoop() {
    // while loop is pretty much the same as java's
    var x = true
    while (x) {
        println("hi")
        x = false
    }

    do {
        println("hi again")
    } while (x)
}

fun fizzBuzz(i: Int): String {
    return when {
        i % 15 == 0 -> "FizzBuzz"
        i % 3 == 0 -> "Fizz"
        i % 5 == 0 -> "Buzz"
        else -> "$i"
    }
}

fun forLoop() {
    // use a range operator, just like how powershell does it
    for (i in 1..100) {
        println(fizzBuzz(i))
    }
}

fun forLoopBackwardsWithStep() {
    // looks like Kotlin has some python-like syntax for for loops
    for (i in 100 downTo 1 step 2) {
        println(fizzBuzz(i))
    }
}

fun forExclusiveRange() {
    // once again with the python-like syntax...I don't get what's wrong with the original java syntax but whatever
    for (i in 1 until 100) {
        println(fizzBuzz(i))
    }
}

fun iterateOverMap() {
    val binaryReps = TreeMap<Char, String>()
    // it is pretty cool how Kotlin can automatically iterate over a range represented by characters tho
    for (c in 'A'..'Z') {
        val binaryForm = Integer.toBinaryString(c.toInt())
        // I like this way of accessing maps, it's nice and succinct
        binaryReps[c] = binaryForm
    }
    // now iterate over each pair in the map
    for ((letter, binaryForm) in binaryReps) {
        println("$letter = $binaryForm")
    }
}

fun iterateOverListWithIndex() {
    // there's a way to iterate with an index value that's automatically constrained in the list. This is one of the things I was worried about Kotlin not supporting
    val lst = arrayListOf("01", "10", "11")
    for ((index, element) in lst.withIndex()) {
        println("$index : $element")
    }
}

fun main() {
    whileLoop()
    forLoop()
    forLoopBackwardsWithStep()
    forExclusiveRange()
    iterateOverMap()
    iterateOverListWithIndex()
}