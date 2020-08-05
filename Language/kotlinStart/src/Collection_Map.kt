fun main() {
    var map = mutableMapOf<String, String>()

    map.put("키1","값1")
    map.put("키2","값2")
    map.put("키3","값3")

    println(map)

    map.put("키1","수정") // 이미 존재하는 key로 put 매서드 실행시 value 갱신됨.
    println(map)

    map.remove("키3")
    println(map)
    for(m in map){
        println("key: ${m.key} / value: ${m.value}")
    }

}