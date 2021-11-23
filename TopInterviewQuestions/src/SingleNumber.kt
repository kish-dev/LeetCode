class SingleNumber {
    fun singleNumber(nums: IntArray): Int {
        var res = nums[0]
        for(i in 1 until nums.size) {
           res = res.xor(nums[i])
        }
        return res
    }
}

fun main() {
    val s = SingleNumber()
    print(s.singleNumber(intArrayOf(4,1,2,1,2)))
}