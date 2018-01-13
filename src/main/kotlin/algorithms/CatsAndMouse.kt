package algorithms

import java.util.*

fun <T> Collection<T>.format(): String = this.fold(StringBuffer()) { acc, elem ->
    acc.append("$elem \n")
}.toString()

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val q = scanner.nextInt()

    val rng = (1..q).map {
        val catA = scanner.nextInt()
        val catB = scanner.nextInt()
        val mouse = scanner.nextInt()

        decideWinner(catA, catB, mouse)
    }

//    println(rng.javaClass)

    println(rng.format())
}


fun decideWinner(catA: Int, catB: Int, mouse: Int): String {
    val catAdistance = Math.abs(catA - mouse)
    val catBDistance = Math.abs(catB - mouse)

    return if (catAdistance == catBDistance) "Mouse C"
    else if (catAdistance > catBDistance) "Cat B"
    else "Cat A"

}

