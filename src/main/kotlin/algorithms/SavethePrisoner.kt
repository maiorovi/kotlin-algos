package algorithms

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val t = sc.nextInt()

    (0 until t).forEach {
        val n = sc.nextLong()
        val m = sc.nextLong()
        val s= sc.nextLong()

        println(findIdOfAPrisoner(n, m, s))
    }
}

fun findIdOfAPrisoner(n: Long, m: Long, s: Long):Long =(m + (s - 2)) % n + 1
/*
999999998
499999999

 */