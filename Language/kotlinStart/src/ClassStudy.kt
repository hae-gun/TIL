fun main() {
    var c1 = myClass("c1")
    var c2 = myClass("c2")
    var c3 = myClass("c3")
    var c4 = myClass("c4")

    var myClass2 = myClass2("Gilldong",20)
    println(myClass2.getName())
    var dataClass = myDataClass("a",123);
    println(dataClass)
    dataClass.age = 10
    dataClass.name = "123"
    println(dataClass)

}


class myClass(name: String) {

    var number: Int

    init {
        number = 0
        println("$name 객체 생성 완료")
    }

}

class KotlinFour(name: String) {
    companion object {
        private val name: String = ""
        var one: String = name
        fun printOne() {
            println("one 에 입력된 값은 $one 입니다.")
        }
    }
}

class myClass2 (name: String, age: Int) {
   private var name = name
    private var age = age

//    constructor(name: String, age: Int) {
//        this.name = name
//        this.age = age
//    }

    fun changeAge(age: Int) {
        this.age = age
    }

    fun getName():String{
        return this.name
    }

    override fun toString(): String {
        return "이름: $name, 나이: $age"
    }
}

data class myDataClass(var name:String,var age:Int ){



    override fun toString(): String {
        return "이름은 $name 이요 나이는 $age 올시다."
    }
}

