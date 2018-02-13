package algorithms

import java.util.*

fun main(args:Array<String>) {
    val sc = Scanner(System.`in`)
    val s = sc.next()

    println(s.filter { s -> s.isUpperCase() }.length + 1)
}