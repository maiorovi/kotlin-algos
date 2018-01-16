package algorithms

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val i = sc.nextInt()
    val j = sc.nextInt()
    val k = sc.nextInt()

    println((i..j).map { if(isBeautiful(it, reverseInt(it), k)) 1 else 0 }.sum())
}

fun isBeautiful(day: Int, reversedDay: Int, k: Int): Boolean = (Math.abs(day -reversedDay) % k) == 0

fun reverseInt(initialInt: Int): Int {
    var result = 0
    var start = initialInt


    while(start > 0) {
        result = 10*result + start % 10

        start /= 10
    }

    return result
}
