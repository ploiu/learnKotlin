package chapter3

/* 
* an extension function. Though it looks like we're modifying the class (much like a js prototype), 
* in reality it's a static method that Kotlin allows us to invoke directly on the object through syntax
* sugar. This method will need to be imported to be used in other classes
*/
fun String.lastChar(): Char = this[this.length - 1]

// rewrite the joinToString method to make it an extension function
fun <T> Collection<T>.joinToString(separator: String = " ", prefix: String = "[", postFix: String = "]"): String {
    val result = StringBuilder(prefix)
    for ((i, item) in this.withIndex()) {
        // if i is 0, we don't want to append the separator
        if (i > 0) {
            result.append(separator)
        }
        result.append(item)
    }
    result.append(postFix)
    return result.toString()
}

// extension property for String, like our first extension function
val String.lastChar: Char
    get() = this[this.length - 1]

fun main() {
    println("hello".lastChar() == "hello".lastChar)
// use the joinToString extension method we created above
    val list = (1..10).toList()
    println(list.joinToString(separator = "; "))
}