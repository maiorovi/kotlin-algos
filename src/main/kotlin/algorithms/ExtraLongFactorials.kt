package algorithms

import java.math.BigInteger
import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val digit = sc.nextInt()

    println(extraLongFactorials(digit))
}


fun extraLongFactorials(digit: Int):BigInteger =
    (2..digit).map { BigInteger(it.toString()) }.fold(BigInteger("1")) { acc, value ->
        acc.multiply(value)
    }