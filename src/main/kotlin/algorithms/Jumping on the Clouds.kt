package algorithms

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()

    val arr = IntArray(n)

    for (i in 0..arr.lastIndex) {
        arr[i] = sc.nextInt()
    }

    println(countJumps(arr))
}

fun countJumps(arr: IntArray):Int {
    var jumps = 0
    var i = 0

    while(i < arr.lastIndex) {
        if (i < arr.lastIndex - 1 && !isTunderCloud(arr[i+2])) {
            jumps += 1
            i += 2
        } else {
            jumps += 1
            i += 1
        }
    }

    return jumps
}

fun isTunderCloud(i: Int) = i == 1