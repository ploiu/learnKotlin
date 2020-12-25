data class Person(val name: String, val age: Int? = null)

fun main() {
    val people = listOf(Person("test"), Person("test2", 30))

    val oldestPerson = people.maxByOrNull { it.age ?: 0 }
    println("The oldest person is $oldestPerson")
}