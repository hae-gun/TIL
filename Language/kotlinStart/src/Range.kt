fun main() {
//    var x=10
//    var y=9
//    println(x in 1..y+1)
//    if (x in 1..y+1){
//        println("fits in range")
//    }

//    val list = listOf("a", "b", "c")
//
//    if (-1 !in 0..list.lastIndex) {
//        println("-1 is out of range")
//    }
//    if (list.size !in list.indices) {
//        println("list size is out of valid list indices range, too")
//    }
//
//    for (x in 1..5) {
//        print(x)
//    }
//    println()
//    for (x in 1..10 step 2) {
//        print(x)
//    }
//    println()
//    for (x in 9 downTo 0 step 3) {
//        print(x)
//    }

    val items = listOf("apple", "banana", "kiwifruit", "orange")
    for (item in items) {
        println(item)
    }
    println("------------------------------------------------------------")
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }
    println("------------------------------------------------------------")
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    // Stream
    fruits
            .filter { it.startsWith("a") } // a로 시작하는 단어 fillter
            .sortedBy { it }                     // 정렬
            .map { it.toUpperCase() }            // 대문자로 변경
            .forEach { println(it) }             // 루프 돌면서 출력
    var a = Customer("a", "b")
    var b = Customer("a", "b")
    var c = Customer()


    println("a.a: "+a.a)
    println("b.a: "+b.a)
    a.plusA()
    println("a.a: "+a.a)
    println("b.a: "+b.a)
    b.plusA()
    println("a.a: "+a.a)
    println("b.a: "+b.a)

    println(a==b)
    println(a.equals(b))
    val d = C("a","b")

    val customer = Customer()
    var
    val positives = list.filter { x -> x > 0 }
}

data class Customer(val name: String="", val email: String=""){
    var a=0;
    fun plusA(){
        this.a++
    }
}
data class C(val name: String, val email: String)