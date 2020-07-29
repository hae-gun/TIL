fun main() {

    //    printProduct("2","abc")
    fun printLength(obj: Any) {
        println("'$obj' string length is ${getStringLength(obj) ?: "... err, is empty or not a string at all"} ")
    }
    printLength("Incomprehensibilities")
    printLength(1000)
    printLength("")
    printLength(listOf(Any()))
    println(Any())

//    println(listOf(a))

}

//fun getStringLength(obj: Any): Int? {
//    if (obj !is String) return null
//
//    // `obj` is automatically cast to `String` in this branch
//    return obj.length
//}

fun getStringLength(obj: Any) :Int?{
    if(obj is String && obj.length>0){
        return obj.length
    }
    return null
}

fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    println(y is Int)

    // Using `x * y` yields error because they may hold nulls.
    if (x != null && y != null) {
        // x and y are automatically cast to non-nullable after null check
        println(x * y)
    } else {
        println("'$arg1' or '$arg2' is not a number")
    }
}