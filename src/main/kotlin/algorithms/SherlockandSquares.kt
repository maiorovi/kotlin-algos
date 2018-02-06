package algorithms

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val t = sc.nextInt()

    (0 until t).forEach {
        val low = sc.nextInt()
        val high = sc.nextInt()

        println(countSquaresInRange(low..high))
    }
}

fun countSquaresInRange(range: IntRange) = (range.last.sqrt().floor() + 1) -  (range.first.sqrt().ceil())



fun Int.isSquare(): Boolean = Math.sqrt(this.toDouble()).rem(1.0) < 0.00000000001

fun Int.sqrt():Double = Math.sqrt(this.toDouble())

fun Double.ceil() =  Math.ceil(this).toInt()

fun Double.floor() = Math.floor(this).toInt()

