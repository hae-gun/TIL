fun main(){

//    val p: String by lazy {
//        "asdf" +
//        "aabcd"
//    }
//    println(p)
//    p.potPot()
    var single1 = Singleton.getInstance()
    var single2 = Singleton.getInstance()
    single1.a++
    println(single2.a)
}


fun String.potPot() {
    println("!!")
}

object Singleton{
    var a=0
    var b=0

    fun getInstance():Singleton{
        return this
    }
}