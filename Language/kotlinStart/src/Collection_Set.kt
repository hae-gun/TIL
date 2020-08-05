fun main(){

//    var set = mutableSetOf<String>()
//    set.add("a")
//    set.add("b")
//    set.add("c")
//    set.add("d")
//    // 중복허용 안함.
//    set.add("d")
//
//
//    println(set)
//
//    var CharArray = CharArray(10)
//
//   for(i in CharArray.indices){
//       CharArray[i] = 'a'+i
//   }
//    println(CharArray)

//    var stringArray = Array(10, {item->"a"})
//    for(x in stringArray.indices){
//        println(stringArray[x])
//    }
//
    var mutableList = mutableListOf("MON","TUE","WED","FRI")
    println(mutableList)

    mutableList.add("SUN")
    println(mutableList)

    println("가져온 값: ${mutableList.get(0)}")

    mutableList.set(1,"TTT")
    println(mutableList)

    mutableList.removeAt(mutableList.size-1)
    println(mutableList)


}


