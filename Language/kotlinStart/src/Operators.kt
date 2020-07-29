

fun main() {
    var a = 1
// simple name in template:
    val s1 = "a is $a"

    a = 2
// arbitrary expression in template:
    val s2 = "${s1.replace("is", "was")}, but now is $a"

    println(s1)
    println(s2)

    println(bigOne(1,2))
    println(maxOf(1,3))
}
fun bigOne(num1:Int,num2:Int) = if(num1>num2) num1 else num2

/*
fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    }else if(a==b){
        return 0
    }else{
        return b
    }
}
*/

fun maxOf(a:Int,b:Int) = if(a>b) a else if(a<b) b else 0
