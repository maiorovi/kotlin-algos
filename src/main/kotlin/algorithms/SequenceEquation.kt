package algorithms

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()

    val arr = IntArray(n)

    (0 until n).forEach {
        arr[it] = sc.nextInt()
    }
    solve(arr, n).forEach {
        println(it)
    }
}

fun solve(arr: IntArray, n: Int): IntArray {
    val valueToIndex = hashMapOf<Int, Int>()

    val result = IntArray(n)

    (0 until arr.size).forEach {
        valueToIndex[arr[it]] = it + 1
    }

    (1..n).forEach {
        val valueToFind = valueToIndex.getValue(it)
        result[it-1] = valueToIndex.getValue(valueToFind)
    }

    return result
}