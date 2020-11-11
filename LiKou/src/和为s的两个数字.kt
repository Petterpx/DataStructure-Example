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
}