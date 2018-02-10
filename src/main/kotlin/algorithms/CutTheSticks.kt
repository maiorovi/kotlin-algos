package algorithms

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()

    val arr = IntArray(n)

    (0 until n).forEach { arr[it] = sc.nextInt() }

    findTicks(arr).dropLast(1).forEach {
        println(it)
    }
}

fun findTicks(arr: IntArray): List<Int> {
    var useThis = arr.copyOf().toList()
    val l = arrayListOf<Int>()
    l.add(useThis.size)

    useThis = useThis.sorted()

    while(useThis.size > 0) {
        useThis = useThis.map { it - useThis[0]  }.dropWhile { f -> f <= 0 }
        l.add(useThis.size)
    }

    return l
}
