package chapter3

import java.lang.StringBuilder

// this is a java-like way of doing something that can be done in more idiomatic Kotlin (which the book will show me how later)
fun <T> joinToString(collection: Collection<T>, separator: String, prefix: String, postfix: String): String {
    val result = StringBuilder(prefix)
    // iterate through the collection and append each one to the result
    for ((i, item) in collection.withIndex()) {
        // if i is 0, don't append the separator
        if (i > 0) {
            result.append(separator)
        }
        result.append(item)
    }
    result.append(postfix)
    return result.toString()
}

@JvmOverloads // this annotation generates overloads for each default param for use in java code
fun <T> joinToStringWithDefaultValues(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "[",
    postFix: String = "]"
) = joinToString(collection, separator, prefix, postFix)

fun main() {
    val list = setOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val result = joinToString(list, separator = " ", prefix = "[", postfix = "]")
    println(result)
    val defaultValuesResult = joinToStringWithDefaultValues(list)
    println(defaultValuesResult)
}