package chapter2

import java.util.Random

// a class with getters, setters, and constructor automatically generated
class Person(val name: String, var isMarried: Boolean)

val person = Person("name", false)

// a class with a custom accessor
class Rectangle(val height: Int, val width: Int) {
    /* accessor declared in a manner similar to C#...note how isSquare does not get square brackets, but the get() can
     (or it can be an expression) */
    val isSquare: Boolean
        get() = height == width
    
    val dimensions: String
        get() = "${width}x${height}"

}

fun main() {
    val rect = Rectangle(10, 20)
    val square = Rectangle(10, 10)
    
    val random = Random(System.currentTimeMillis())
    val randomRect = Rectangle(random.nextInt(), random.nextInt())

    println("is rect a square? ${rect.isSquare}")
    println("is square a square? ${square.isSquare}")
    println("is randomRect a square? ${randomRect.isSquare}\nDimensions: ${randomRect.dimensions}")
}
