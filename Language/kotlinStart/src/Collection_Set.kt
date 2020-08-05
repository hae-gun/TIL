fun main(){
    var set = mutableSetOf<String>()

    set.add("JAN")
    set.add("FEB")
    set.add("MAR")
    set.add("JAN") // 중복 불가능

    println(set)

    set.remove("JAN") // 값으로 삭제가능.
    println(set)

}