fun main() {

    var kotlin = Kotlin(1)
//    var kotlin2 = Kotlin2(1)
//
//    var k1 = Kotlin2(1,"aaa")
//    var k2 = Kotlin2("aaa",1)
    var kot2 = Kotlin2(1, 1, "tom")
    println(kot2)
}


// 클래스 구성

//class Kotlin{
//
//    // 생성자가 없으면 아무것도 없는 init 블록이 실행된다.
//    init{
//        println("Kotlin객체 생성..")
//    }
//}
class Kotlin constructor(num: Int) { // constructor 생략 가능.

    init {
        println("Kotlin객체 생성..")
    }
}

class Kotlin2 {

    var a: Int
    var b: Int
    var name: String


    constructor(a: Int, b: Int, name: String) {
        this.a = a
        this.b = b
        this.name = name
    }


    override fun toString(): String {
        return "Kotlin2(a=$a, b=$b, name=$name)"
    }


}