//import kotlin.text.*
//fun sum(a:Int, b:Int):Int{
//    return a+b
//}
fun main(){
    println("Hello, World!")
    println("sum: ${sum(1,2,3)}")
    printSum(1,2)
    println(stringLength("abcd"))

    val a = 1
//    a=2

}


fun sum(a:Int,b:Int):Int{
    return a+b
}
// 다형성 적용.
fun sum(a:Int,b:Int,c:Int) = a+b+c

////fun printSum(a: Int, b: Int): Unit {
////    println("sum of $a and $b is ${a + b}")
//}

fun printSum(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}


fun stringLength(str: String): Int? {
   if (str.isNotEmpty()){
       return str.length
   }
    return null
}