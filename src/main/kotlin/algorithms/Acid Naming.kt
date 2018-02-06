package algorithms

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val q = sc.nextInt()

    (0 until q).forEach {
        val w = sc.next()
        println(nameAcid(w))
    }
}

fun nameAcid(naming: String) = when {
        naming.startsWith("hydro") && naming.endsWith("ic") -> "non-metal acid"
        naming.endsWith("ic") -> "polyatomic acid"
        else -> "not an acid"
    }