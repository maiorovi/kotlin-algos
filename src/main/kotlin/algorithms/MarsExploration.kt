package algorithms

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val s = sc.next()
    var count = 0


    for (it in s.indices) {
        val q = it % 3
        if (q == 0 && s[it] != 'S') count+=1
        if (q == 1 && s[it] != 'O') count+=1
        if (q == 2 && s[it] != 'S') count+=1
    }

    println(count)
}