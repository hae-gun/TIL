fun main() {
    var ca = childActivity("soon")

    var num = myActivity(0)
    num.number = 11
    println(num.number)

    println("asdf".plus("bcb"))
}

open class Activity {
    val PI = Math.PI
    fun getPi() = this.PI

    open var number: Int = 15
}

class myActivity(override var number: Int) : Activity() {
}

class childActivity(private var name: String) : Activity() {


}


fun String.plus(word: String) :String{
    return this + word
}
