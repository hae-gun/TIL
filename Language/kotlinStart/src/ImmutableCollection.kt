fun main(){
    val IMMUTABLELIST = listOf("JAN","FEB","MAR")
//    IMMUTABLELIST.add() // 불가능.
//    IMMUTABLELIST.removeAt() // 불가능.
//    IMMUTABLELIST.set() // 불가능.
    println("리스트의 두번째 값은 ${IMMUTABLELIST.get(1)} 입니다.") // get 함수만 사용가능.



    val DAY_LIST = listOf("월","화","수","목","금","토","일") // java 에서 enum class 처럼 사용가능.

    for(s in DAY_LIST){
        println("$s : ~~~~")
    }

}