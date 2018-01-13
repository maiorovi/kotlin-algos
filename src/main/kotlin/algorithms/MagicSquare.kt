package algorithms

import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val arr = arrayOfNulls<IntArray>(3)

    for ( i in 0..2) {
        val tmpArr = IntArray(3)
        for (j in 0..2) {
            tmpArr[j] = scanner.nextInt()
        }
        arr[i] = tmpArr
    }

    printTwoDimensionalArray(arr)
}

fun makeMagic(arr: Array<IntArray>) : Int {

    return 0;
}

fun printTwoDimensionalArray(arr: Array<IntArray?>) {
    for (intArr in arr) {
        if (intArr != null) {
            for (elem in intArr) {
                print("$elem ")
            }
        }
        println()
    }
}