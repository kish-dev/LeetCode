class ContainsDuplicate {
    fun containsDuplicate(nums: IntArray): Boolean {
        nums.sort()
        for(i in 0..nums.size - 2) {
            if(nums[i] == nums[i+1]) {
                return true
            }
        }
        return false
    }
}

fun main() {
    val nums = IntArray(7) { i -> i + 1 }
    val k = 3
    val r = RotateArray()
    r.rotate(nums, k)
}