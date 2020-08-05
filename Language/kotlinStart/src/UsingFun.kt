fun main(){

//    var squareResult = square(30)
//    println("30의 제곱근은 $squareResult 입니다.")
//
//    printSum(3,5)
//
//    var PI = getPi()
//    println("PI 값은 $PI 입니다.")
//    newFunction("최혜근")
//    newFunction("김철수",30)
//    newFunction("홍길동",30,80.0)

    var x = 10
    println("$x * $x = ${mySquare(x)}")
    myPrintSum(1,2)
    println("PI = ${getPi()}")

}

fun getPi(): Double {
    return Math.PI
}

// 파라미터 정의
fun newFunction(name:String,age:Int = 27, weight:Double = 72.5){
    println("$name 의 나이는 $age 이며 몸무게는 $weight 입니다.")
}
fun mySquare(x:Int):Int{
    return x * x
}
// = 로 함수 선언가능.
fun myPrintSum(x:Int,y:Int)=println("$x + $y = ${x+y}")



