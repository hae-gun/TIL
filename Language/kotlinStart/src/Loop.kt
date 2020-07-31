fun main(){
    // 1~10 -> 1..10
    for(i in 1..10){
        if(i==10){
            println("$i")
        }else{
            print("$i..")
        }
    }
    // 1~9 1 until 10
    for(i in 1 until 10){
        if(i==10){
            println("$i")
        }else{
            print("$i..")
        }
    }
    //until 활용
    var set = arrayOf("JAN","FEB","MAR","APR","MAY","JUN")
    for(index in 0 until set.size){
        println("index: $index 값은 ${set.get(index)} 입니다.")
    }
    // step : 해당 수만큼 증가!
    for(i in 1 until 10 step 2){
        println("$i !!!!")
    }
    // 숫자 감소 : downTo
    for (index in 10 downTo 0){
        println("현재 숫자: $index")
    }

    //while loop
    /*while(조건){
        // 실행코드
    }*/
    var current = 1
    var until = 12
    while (current < 12){
        if(current==7){
            current++
            continue
        }
        else if(current==10)
            break;
        println("현재 값은 ${current++} 입니다.")
    }

}