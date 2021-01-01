package chapter3

fun main() {
    /* string split original method has been hidden because it's apparently "confusing"...I don't necessarily agree with 
    * the method being hidden, but they offer replacements for it so I guess it's fine*/
    println("12.345-6.A".split("[.-]".toRegex()))
    // use kotlin string extensions to parse the different parts of a file path
    val filePath = "C:/Users/username/OneDrive/Documents/test.xlsx"
    parseFilePath(filePath)
    // now with regex stuff
    parseFilePathWithRegex(filePath)
    println(tripleQuotedString())
    // dollar sign needs to be escaped in a special way
    println("""${'$'}3.50""")
}

fun parseFilePath(path: String) {
    // get the directory path leading up to the file
    val directoryPath = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    // now get specific parts of the file
    val fileName = fullName.substringBeforeLast(".")
    val fileExtension = fullName.substringAfterLast(".")
    println("directory: $directoryPath\nfullName: $fullName\nfileName: $fileName\nfileExtension: $fileExtension")
}

fun parseFilePathWithRegex(path: String) {
    // use a triple-quoted string and regular expressions
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val result = regex.matchEntire(path)
    if (result != null) {
        // destructure the regex
        val (directory, filename, extension) = result.destructured
        println("directory: $directory\nfile name: $filename\nextension: $extension")
    }
}

fun tripleQuotedString() = """
            _   _
           (.)_(.)
        _ (   _   ) _
       / \/`-----'\/ \
     __\ ( (     ) ) /__
     )   /\ \._./ /\   (
jgs   )_/ /|\   /|\ \_(
""".trimIndent()