package algorithms

import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val  n = scanner.nextInt()
    val arr = IntArray(n)

    (0 until n).map {
        arr[it] = scanner.nextInt()
    }

    println(doJob(arr))
}

fun doJob(arr: IntArray): Int {
    var max = 0;
    var maxSoFar = 1
    Arrays.sort(arr)

    var prev = arr[0]

    (1 until arr.size).map {
        if (arr[it] - prev <= 1) {
            maxSoFar++
        } else {
            maxSoFar = 1
            prev = arr[it]
        }

        max = Math.max(maxSoFar, max)

    }

    return max
}

fun printArray(arr: IntArray) {
    for(i in arr) {
        print("$i ")
    }
}
// 1 3 3 4 5 6