package chapter2

data class Person(val name: String, val salary : Long) {

    constructor(name: String) : this(name, 0)

    companion object Loader {
        fun fromJson(jsonText: String): Person {
            return Person("abc")
        }
    }

    object NameComparator : Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int = p1.name.compareTo(p2.name)
    }
}
