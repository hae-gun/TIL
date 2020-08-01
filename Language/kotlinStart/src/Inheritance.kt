fun main() {
    var ca = childActivity("soon")
    ca.getPI()
}

open class Activity{
    val PI = Math.PI
    fun getPi() = this.PI
}

class childActivity(private var name:String) : Activity(){

    override fun getPI(){
        println("$name has ${super.getPi()}")
    }
}