package chapter6

fun main(args: Array<String>) {
    println(printAllCaps("abc"))

    val email: String? = "mai_9@gm.com"
    email?.let { email -> sendEmailTo(email)}
}

fun printAllCaps(s: String?) {
    val allCaps: String? = s?.toUpperCase()

    println(allCaps)
}

fun sendEmailTo(email: String) {
    println("sending email to $email")
}
