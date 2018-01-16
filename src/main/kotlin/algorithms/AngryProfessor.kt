package algorithms

import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val t = scanner.nextInt()

    (0 until t).forEach {
        val n = scanner.nextInt()
        val k = scanner.nextInt()

        val studentsArrival = IntArray(n)

        (0 until n).forEach { studentsArrival[it] = scanner.nextInt() }
        println(if(shouldStartClass(studentsArrival, k)) "NO" else "YES")
    }
}

fun shouldStartClass(studentsArrival: IntArray, cancelationThreshold: Int): Boolean = studentsArrival.fold(0) { acc, elem ->
    if (elem <= 0) acc + 1
    else acc
} >= cancelationThreshold


