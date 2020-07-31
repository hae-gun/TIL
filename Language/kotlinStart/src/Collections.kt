fun main() {
    // list collection : mutableListOf()
    var list = mutableListOf("a", "b", "c")
    list.add("d")
    for (a in list) {
        println("$a!!")
    }

    //generic 사용하기
    var stringList = mutableListOf<String>()
    stringList.add("월")
    stringList.add("화")
    stringList.add("수")
    for (s in stringList) {
        println("$s $s $s")
    }
//    gugudan()

    // set : 중복을 허용하지 않는 리스트
    var set = mutableSetOf<String>()
    set.add("aaaa")
    // 아래는 안들어감
    set.add("bbbb")
    set.add("cccc")
    var dd = "ddddd"
    var aa = "bbbbb"
    set.add(dd)
    set.add(aa)
    for (s in set) {
        println(s)
    }
    println("-------------")
    var aaa = "aaaa"
    set.remove(aaa)
    set.remove("bbbb")
    set.remove("bbbbb")
    for (s in set) {
        println(s)
    }

    //map : key, value
    var map = mutableMapOf<String,Int>()
    map.put("a",123)
    // key 값은 중복 불가능. 중복시 나중 값이 저장.
    map.put("a",321)
    map.put("b",222)
    for(m in map){
        println("${m.key} : ${m.value}")
    }

    // Immutable Collection
    // 기존 컬렉션에서 mutable이라는 접두어가 제거된 형태로 사용된다.
    // 불변형 컬랙션 이므로 한번 입력후 변경 불가능. add, set함수 지원안함.
    // java 에서 enum 과 같은? 느낌..
    var IMMUTABLE_LIST = listOf("JAN","FEB","MAR")
    println(IMMUTABLE_LIST.get(0))



}

fun gugudan() {
    var i: Int
    var j: Int
    for (i in 1..9) {
        for (j in 1..9) {
            print("$j * $i = ${i * j} ")
        }
        println()
    }
}

