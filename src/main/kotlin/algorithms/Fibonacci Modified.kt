package algorithms

import java.math.BigInteger
import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val t1 = sc.nextBigInteger()
    val t2 = sc.nextBigInteger()
    val n = sc.nextBigInteger()
    println(fib(t1, t2, n))
}

fun fib(t1: BigInteger, t2: BigInteger, n: BigInteger): BigInteger {
    var tPrevPrev = t1
    var tPrev = t2

    for (i in 2 until n.toInt()) {
        val tmp = tPrevPrev + tPrev*tPrev
        tPrevPrev = tPrev
        tPrev = tmp
    }

    return tPrev
}