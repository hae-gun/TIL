fun describe(obj: Any): String =
        when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }

fun main() {
    var a: String

    a = describe(1)
    println(a)
    a = describe("Hello")
    println(a)
    a = describe(11111111L)
    println(a)
    a = describe(7.55f)
    println(a)
    a = describe("")
    println(a)
}