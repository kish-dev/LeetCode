import kotlin.math.max
import kotlin.math.min

fun main() {
    println(maxArea(intArrayOf(3, 100, 3, 100, 7, 2, 12, 6)))
}

fun maxArea(height: IntArray): Int {


    var currentMax = 0

    var j = height.size - 1
    var i = 0

    while(i < j) {
        currentMax = max(currentMax, ((j - i) * min(height[i], height[j])))
        if(height[i] < height[j]) {
            ++i
        } else {
            --j
        }
    }

    return currentMax
}

