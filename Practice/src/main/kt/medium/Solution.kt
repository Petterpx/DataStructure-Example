package kt.medium

/**
 * @Author petterp
 * @Date 2020/11/16-12:52 下午
 * @Email ShiyihuiCloud@163.com
 * @Function 递增的三元子序列
 * https://leetcode-cn.com/problems/increasing-triplet-subsequence/
 */
class Solution {

    /** min记录当前数组最小元素，secondMin为第二小，接下来不断更新 min和secondMin
     * 如果下一个元素大于secondMin,即为合理的三元子序列*/
    fun increasingTriplet(nums: IntArray): Boolean {
        if (nums.size < 3) return false
        var min = Int.MAX_VALUE
        var secondMin = Int.MAX_VALUE
        nums.forEach {
            when {
                it <= min -> min = it
                secondMin > it -> secondMin = it
                it > secondMin -> return true
            }
        }
        return false
    }
}
