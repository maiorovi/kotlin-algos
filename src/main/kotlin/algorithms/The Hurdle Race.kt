package algorithms

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()
    val k = sc.nextInt()
    val arr = IntArray(n)

    (0 until n).forEach {
         arr[it] = sc.nextInt()
    }

    println(countValue(arr, k))
}

fun countValue(arr: IntArray, k: Int): Int {
    val i = arr.fold(-1, Math::max) - k
    return if (i < 0) 0 else i
}