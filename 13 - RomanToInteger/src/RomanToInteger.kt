
fun main() {
    val s = readLine()!!
    val map: Map<Char, Int> = HashMap(
        mapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )
    )

    var result = 0
    var previousNumber = map[s[0]]!!
    result -= previousNumber
    for (char in s) {
        val current = map[char]!!
        if(previousNumber < current) {
            result -= previousNumber
        } else {
            result += previousNumber
        }
        previousNumber = current
    }
    result += previousNumber

    println(result)
}