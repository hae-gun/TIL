fun main(){
    var a = 3
    println("$a * $a = ${square(a)}")
    printSums(1,2)

    var x = getSums(1,2,3)
    var y = getSums(1,2)
    println("$x ------- $y")


}

// fun 함수명(파라미터 이름: 타입): 반환타입{
//  return 값
// }

//  반환 타입 있는 함수
fun square(x:Int):Int{
    return x*x
}
// 반환 타입 없는 함
fun printSums(x:Int,y:Int){
    println("$x + $y = ${x+y}")
}

// 파라미터 기본값 선언
// 없을때 디폴트로 설정.
fun getSums(num1:Int, num2:Int,num3:Int=10):Int{
    return num1 + num2 + num3
}