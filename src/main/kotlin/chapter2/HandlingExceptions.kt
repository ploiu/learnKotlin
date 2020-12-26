package chapter2

import java.io.FileNotFoundException
import java.io.InputStreamReader

fun testThrow(value: Int) = if (value in 0..100) true else throw Exception("$value is not between 0 and 100!")

// get a file on the classpath, parse the first line, and put the number through testThrow. The file's first line can be changed
fun testReadFile(): Boolean {
    val stream = ClassLoader.getSystemResourceAsStream("chapter2/testThrow.txt")
    // getSystemResourceAsStream can return null, so check for it
    if (stream != null) {
        /* get a reader for the stream. I'm intentionally avoiding ARM blocks since I think the book will teach me a 
        Kotlin-like way to do them later */
        val streamReader = InputStreamReader(stream)
        try {
            // looks like there's no simple readLine method...which is annoying
            val lines = streamReader.readLines()
            return testThrow(Integer.parseInt(lines[0]))
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            // close our resources to avoid memory leaks
            streamReader.close()
            stream.close()
        }
    } else {
        throw FileNotFoundException("Could not find the file!")
    }
    return false
}

fun main() {
    println(testReadFile())
}