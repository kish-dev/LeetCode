fun main() {
    var words: Array<String> = arrayOf("fooo", "barr", "wing", "ding", "wing")
    val s = "lingmindraboofooowingdingbarrwingmonkeypoundcake"
    println(findSubstring(s, words))
}

fun findSubstring(s: String, words: Array<String>): List<Int> {
    if (words.isEmpty()) {
        return emptyList()
    }

    val wordLength = words[0].length
    val windowLength = words.size * wordLength

    if (windowLength > s.length) {
        return emptyList()
    }

    val map = mutableMapOf<String, Int>()
    for (word in words) {
        if (map.containsKey(word)) {
            map[word] = (map[word]!! + 1)
        } else {
            map[word] = 1
        }
    }
    val list = mutableListOf<Int>()

    for (i in 13..(s.length - windowLength)) {

        val tempMap = mutableMapOf<String, Int>()

        val checkString = s.subSequence(i, i + windowLength)
        var isConcat = true

        for (j in 0..(checkString.length - wordLength) step wordLength) {
            val word = checkString.subSequence(j, j + wordLength) as String

            if (!map.containsKey(word)) {
                isConcat = false
                break
            } else {
                tempMap[word] = tempMap.getOrDefault(word, 0) + 1
                if (tempMap.getValue(word) > map.getOrDefault(word, 0)) {
                    break
                }
            }

        }

        if (!isConcat) {
            continue
        }

        for (key in map.keys) {
            val tempValue = tempMap[key]
            val mapValue = map[key]
            if (tempValue != mapValue) {
                isConcat = false
                break
            }
        }

        if (isConcat) {
            list.add(i)
        }
    }

    return list

}
