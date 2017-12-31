package chapter2

import java.util.*

fun max(a: Int, b: Int) = if (a > b) a else b

fun main(args: Array<String>) {
    val questions = "The Ultimate Question of Life, The universe, and EveryThing"
    val answer = 42

    println("questions = $questions, answer = $answer")
    println(max(5, 10))
}
