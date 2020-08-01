fun main() {

     var kotlin = Kotlin(1)
//    var kotlin2 = Kotlin2(1)
//
//    var k1 = Kotlin2(1,"aaa")
//    var k2 = Kotlin2("aaa",1)
    var kot2 = Kotlin2(1, 1, "tom")
    println(kot2.getName())

    kot2.setName("마스터")
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

data class Kotlin2(private var a: Int,
                   private var b: Int,
                   private var name: String?) {



    enum class set{
        MON
    }

    init{
        println("${this.javaClass} 생성")
        println("${set.MON}")
    }

    fun getName() = if (name != null && name!!.length > 0) name else "name"

    fun setName (value:String?) {
        if (value != null) {
            if (value.length > 0) name = value else ""
        }
    }


//    constructor(a: Int, b: Int, name: String) {
//        this.a = a
//        this.b = b
//        this.name = name
//    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return "Kotlin2(a=$a, b=$b, name=$name)"
    }


}