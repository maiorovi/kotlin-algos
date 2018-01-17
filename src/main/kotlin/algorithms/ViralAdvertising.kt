package algorithms

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()

    println(calculateDays(n, 5))
}

fun calculateDays(n: Int, startingAmount: Int): Int {
    var current = startingAmount
    var likesAmount = 0

    (1..n).forEach {
        val acceptedUsers = current / 2

        likesAmount += acceptedUsers
        current = acceptedUsers * 3
    }

    return likesAmount
}
