package algorithms

import java.util.*

fun main(arg: Array<String>) {
    val sc = Scanner(System.`in`)

    val target = sc.nextInt()

    val n = sc.nextInt()
    val arr = IntArray(n)

    for (i in 0..arr.lastIndex) {
        arr[i] = sc.nextInt()
    }

    println(count(arr, arr.lastIndex ,target))
}


data class Key(val index: Int, val current: Int)
val map = mutableMapOf<Key, Long>()

fun count(arr:IntArray, index: Int, current: Int):Long {
    if (current == 0) {
        return 1
    }

    if(current < 0) {
        return 0
    }

    if (index < 0 && current > 0) {
        return 0
    }

    val key = Key(index, current)
    if (map.containsKey(key)) {
        return map[key]!!
    }

    val amount = count(arr, index - 1, current) + count(arr, index, current - arr[index])

    map[Key(index, current)] = amount

    return amount
}