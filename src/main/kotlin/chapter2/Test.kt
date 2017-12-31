package chapter2
import chapter2.max;

fun main(args:Array<String>): Unit {
    val person = Person("Egor")

    println(person.name)

    val rectange = Rectangle(30, 30);

    println(rectange.isSquare)

    println("max(3,5)=${max(3,5)}")
}

