class RotateArray {
    fun rotate(nums: IntArray, k: Int): Unit {
        val newArray = IntArray(nums.size)
        val newK = if (k > nums.size) {
            k % nums.size
        } else {
            k
        }
        val prefix = nums.size - newK
        for (i in 0 until newK) {
            newArray[i] = nums[i + prefix]
        }

        for (i in 0 until nums.size - newK) {
            newArray[i + newK] = nums[i]
        }

        for (i in nums.indices) {
            nums[i] = newArray[i]
        }
    }
}

fun main() {
    val nums = IntArray(7) { i -> i + 1 }
    val k = 3
    val r = RotateArray()
    r.rotate(nums, k)
}