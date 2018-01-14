package chapter3

fun main(args: Array<String>) {
    println("12.345-6.A".split("\\.|-".toRegex()))
    println("12.345-6.A".split(".", "-"))
    parsePath("/Users/yole/kotlin-book/chapter.adoc")

}

fun parsePath(path:String) {
//    ""
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val fileName = path.substringBeforeLast(".")
    val extension = path.substringAfterLast(".")

    println("Dir: $directory, name: $fileName, ext: $extension")
}


fun parsePathViaRegexp(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)

    if (matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured

        println("Dir: $directory, name: $filename, ext: $extension")
    }
}