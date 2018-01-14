package chapter3

fun main(args:Array<String>) {
    val l = listOf("args: ", *args)

    l.forEach { println(it)}
}
