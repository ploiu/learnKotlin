package chapter2

fun main(args: Array<String>) {
    // looks like standard ternary isn't in kotlin
    println("Hello, ${if (args.isNotEmpty()) args[0] else "World"}")
}