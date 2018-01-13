package chapter3

fun main(args: Array<String>):Unit {
    val set = hashSetOf(1, 7, 53)

    val list = arrayListOf(1, 7, 53)

    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifthy-three")

    val strings = listOf("first", "second", "fourteenth")

    println(strings.last())
}