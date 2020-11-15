/**
 * @Author petterp
 * @Date 2020/11/10-8:40 下午
 * @Email ShiyihuiCloud@163.com
 * @Function
 */


/** 704-二分查找
 * https://leetcode-cn.com/problems/binary-search/
 * */
fun binarySearch(nums: Array<Int>, target: Int): Int {
    if (nums.isEmpty()) return -1
    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        //计算中间值，等同于(left+right)/2,下面的写法为了避免数组过长时超出int限制
        val temp = (right - left) / 2 + left
        when {
            nums[temp] == target -> return temp
            nums[temp] > target -> right = temp - 1
            nums[temp] < target -> left = temp + 1
        }
    }
    return -1
}


