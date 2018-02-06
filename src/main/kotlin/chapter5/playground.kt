package chapter5

fun main(args: Array<String>) {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))

    println(people.maxBy(Person::age))

    val sum = {x: Int, y: Int -> x + y}

    {println(42)}()
}