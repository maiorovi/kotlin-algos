package algorithms

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val k = sc.nextInt()
    val q = sc.nextInt()

    val arr = IntArray(n)

    (0 until n).forEach { arr[it] = sc.nextInt() }

    val rotatedArray = rotateArray(arr, k)

    (0 until q).forEach {
        val ind = sc.nextInt()
        println(rotatedArray[ind])
    }
}


fun rotateArray(arr: IntArray, rotationCoef: Int): IntArray {
    val tmp = IntArray(arr.size)

    (0 until arr.size).forEach {
        val newInd = (it +rotationCoef) % arr.size
        tmp[newInd] = arr[it]
    }

    return tmp
}