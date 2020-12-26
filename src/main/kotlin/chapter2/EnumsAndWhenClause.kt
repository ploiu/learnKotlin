package chapter2

/* enums are declared slightly different from how they are in java...apparently the word "enum" is only a keyword when 
followed by the word "class" */
enum class Color(val red: Int, val green: Int, val blue: Int) {
    RED(255, 0, 0), ORANGE(255, 165, 0), YELLOW(255, 255, 0),
    GREEN(0, 255, 0), BLUE(0, 0, 255), INDIGO(75, 0, 130), VIOLET(238, 130, 238);

    /**
     * Gets the integer value of this color
     */
    fun rgb() = (red * 256 + green) * 256 + blue
}

fun main() {
    println("Indigo is 0x${Integer.toHexString(Color.INDIGO.rgb())}")
    for (value in Color.values()) {
        println("the warmth of ${value.name} is ${getWarmth(value)}")
    }
    println(mixColors(Color.BLUE, Color.YELLOW))
}

// when is like switch but apparently more powerful...I guess I'll learn more about that later
fun getWarmth(color: Color) = when (color) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
    Color.GREEN -> "neutral"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}

// when expressions can also take any object, not just a constant value
fun mixColors(first: Color, second: Color) = when (setOf(first, second)) {
    setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
    setOf(Color.RED, Color.BLUE) -> Color.VIOLET
    setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
    setOf(Color.VIOLET, Color.BLUE) -> Color.INDIGO
    else -> throw Exception("I didn't define a color for this")
}