package chapter3

fun <T> Collection<T>.joinToString(separator: String = ", ",
                     prefix: String = "",
                     postfix: String = ""):String =
    prefix + this.fold(StringBuffer()){ acc, elem ->
        acc.append(elem.toString())
    } + postfix


fun String.lastChar():Char = this.get(this.length - 1)

val String.firstChar: Char
    get() = get(0)


var StringBuffer.firstChar: Char
    get() = get(0)
    set(value:Char) {
        this.setCharAt(0, value)
    }
