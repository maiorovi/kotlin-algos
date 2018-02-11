package algorithms

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val s = sc.next()
    val n = sc.nextLong()

    println(count(s, n))
}

fun count(s: String, n: Long): Long {
    val letterACount = s.filter { c -> c == 'a' }.length.toLong()
    val q = n / s.length
    val z = n % s.length

    return q*letterACount + s.substring(0, z.toInt()).filter { c -> c == 'a' }.length.toLong()
}
