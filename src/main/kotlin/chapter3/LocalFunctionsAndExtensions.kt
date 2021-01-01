package chapter3

import java.lang.IllegalArgumentException

class User(val id: Int, val name: String, val address: String)

fun User.validateBeforeSave() {
    // local function to check a field on the user
    fun validateField(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("can't save user $id: empty $fieldName")
        }
    }
    validateField(this.address, "address")
    validateField(this.name, "name")
}

fun main() {
    val goodUser = User(0, "hi", "address")
    val badName = User(1, "", "address")
    val badAddress = User(2, "hi", "")

    goodUser.validateBeforeSave()
    try {
        badName.validateBeforeSave()
    } catch (e: IllegalArgumentException) {
        println(e)
    }

    try {
        badAddress.validateBeforeSave()
    } catch (e: IllegalArgumentException) {
        println(e)
    }
}