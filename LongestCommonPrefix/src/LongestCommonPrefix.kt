fun main() {
    val strs: Array<String> = arrayOf(
        "reflower",
        "flow",
        "flight"
    )
    println(longestCommonPrefix(strs))
}

fun longestCommonPrefix(strs: Array<String>): String {

    if (strs.isEmpty()) {
        return ""
    }

    var smallestString: String = strs[0]

    for (string in strs) {
        if (string.length < smallestString.length) {
            smallestString = string
        }
    }

    var currentPrefix = ""
    var nextPrefix = ""

    for (char in smallestString) {
        nextPrefix += char
        for (string in strs) {

            if (!(string.startsWith(nextPrefix))) {
                return currentPrefix
            }
        }
        currentPrefix = nextPrefix
    }


    return currentPrefix
}
