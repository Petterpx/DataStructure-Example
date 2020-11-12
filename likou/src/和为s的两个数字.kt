/**
 * @Author petterp
 * @Date 2020/11/11-10:45 下午
 * @Email ShiyihuiCloud@163.com
 * @Function 剑指offer-和为s的两个数字
 */
class 和为s的两个数字 {

    //利用hashset处理
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val hashSet = HashSet<Int>()
        nums.forEach {
            if (hashSet.contains(target - it)) {
                return intArrayOf(it, target - it)
            } else {
                hashSet.add(it)
            }
        }
        return intArrayOf()
    }


    //此题的数组是递增关系，所以可以采用双指针方式
    //如 nums = [10,26,30,31,47,60]，target=40
    //理解 --right和 ++left 整个变换过程，不断调整整个数组适应大小变化
    fun doubleNeedLe(nums: IntArray, target: Int): IntArray {
        var left = 0
        var right = nums.size - 1
        while (left < right) {
            val cur = nums[left] + nums[right]
            when {
                cur == target -> {
                    return intArrayOf(nums[left], nums[right])
                }
                cur > target -> {
                    --right
                }
                else -> {
                    ++left
                }
            }
        }
        return intArrayOf()
    }

}