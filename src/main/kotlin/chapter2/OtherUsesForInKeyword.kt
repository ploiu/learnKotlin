package chapter2

// this compiles to (65 <= c && c <= 90) || (97 <= c && c <= 122)... the kotlin way is much simpler
fun isLetter(c: Char) = c in 'A'..'Z' || c in 'a'..'z'
fun isNonDigit(c: Char) = c !in '0'..'9'

// use a when expression combined with the in keyword
fun recognizeType(c: Char) = when (c) {
    in 'a'..'z', in 'A'..'Z' -> "$c is a letter!"
    in '0'..'9' -> "$c is a digit!"
    else -> "WHAT THE HELL IS THIS???? [$c]"
}

fun main() {
    println("is q a letter? ${isLetter('q')}")
    println("is 1 a non-digit? ${isNonDigit('1')}")
    println(recognizeType('a'))
    println(recognizeType('3'))
    println(recognizeType('╖'))
}