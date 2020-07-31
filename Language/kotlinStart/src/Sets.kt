fun main() {
    // 배열의 종류 TypeArray
    var student = IntArray(10)
    var longArray = LongArray(10)
    var charArray = CharArray(10)
    var floatArray = FloatArray(10)
    var doubleArray = DoubleArray(10)

    var stringArray = Array(10, { item -> "" })
    for (i in 0..9) {
        stringArray[i] = i.toString()
        println(stringArray.get(i))
        println(stringArray[i])
    }
    var numberSets = arrayOf(1, 2, 3, 4, 5)
    var stringSets = arrayOf("1", "2", "3", "4", "5")

    for (i in 0..(numberSets.size - 1)) {
        print("${numberSets.get(i)} ")
    }
    println()

    for (i in 0..(stringSets.size - 1)) {
        print("${stringSets.get(i)}")
    }


}