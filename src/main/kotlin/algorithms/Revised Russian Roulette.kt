package algorithms

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val doorsAmount = sc.nextInt()
    val arr = IntArray(doorsAmount)

    (0 until doorsAmount).forEach {
        arr[it] = sc.nextInt()
    }

    revisedRussianRoulette(arr).forEach { print("$it ") }
}

fun revisedRussianRoulette(arr: IntArray): IntArray {
    val maxOperations = arr.filter { it == 1 }.size
    var minOperations = 0

    for (i in 0 until arr.size) {
        if (arr[i] == 1) {
            minOperations++
            arr[i] = 0
            if (i != arr.size - 1) arr[i+1] = 0
        }
    }

    return intArrayOf(minOperations, maxOperations)
}