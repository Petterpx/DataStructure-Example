/**
 * @Author petterp
 * @Date 2020/11/10-8:40 下午
 * @Email ShiyihuiCloud@163.com
 * @Function
 */


/** 二分搜索 */
fun binarySearch(nums: Array<Int>, specify: Int): Int {
    if (nums.isEmpty()) return -1
    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        //计算中间值，等同于(left+right)/2,下面的写法为了避免数组过长时超出int限制
        val temp = (right - left) / 2 + left
        when {
            nums[temp] == specify -> return temp
            nums[temp] > specify -> right = temp - 1
            nums[temp] < specify -> left = temp + 1
        }
    }
    return -1
}

fun main() {
    val sums = arrayOf(
        1, 3, 6, 88, 90
    )

    println(binarySearch(sums, 90))
}