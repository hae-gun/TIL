fun main(){
    var a =1
    var b=2
    var c=3

    if(a<b){
        println("1: $a 는 $b 보다 작다.")
    }
    if(a<c){
        println("1: $a 는 $c 보다 작다.")
    }

    if(a<b){
        println("1: $a 는 $b 보다 작다.")
    }else if(a<c){
        println("1: $a 는 $c 보다 작다.")
    }

    //변수에 if문 사용
    a = 5
    b = 3
    var bigger = if(a>b) a else b
    println(bigger)
    // 반환값 사용
    var biggers = if(a>b){
        a = a-b
        a
    }else{
        a = b-a
        a
    }

    println("${biggers +1}")

    //when 절 : 일반적인 프로그래밍의 switch와 유사함
    var which = 10
    when(which){
        1-> println("1 입니다.")
        10-> println("10 입니다.")
    }
    when(which){
        in 1..10-> println("1~10 사이 입니다.")
        in 10..100 -> println("10~100 사이 입니다.")
    }


    // 파라미터 없는 when
    var currentTime = 6
    when{
        currentTime == 5 -> {
            println("현재 시간 5시")
        }
        currentTime > 5 ->{
            println("5시가 넘음!")
        }
        else -> {
            println("??")
        }
    }
    var mon = "mon"
    var day = ".."
    var result = when(day){
        mon->"$mon day"
        else -> false
    }
    println(result)

}