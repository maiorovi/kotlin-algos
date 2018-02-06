package chapter5

fun main(args: Array<String>) {
    var counter = 0

    val inc = { counter++ }
}

val sb = StringBuilder().apply {
    for (c in 'a'.. 'z') {
        append(c)
    }
    append("\n")
}.toString()


