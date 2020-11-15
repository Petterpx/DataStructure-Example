package kt.array

import java.util.*
import kotlin.collections.ArrayList


/**
 * @Author petterp
 * @Date 2020/11/15-10:28 下午
 * @Email ShiyihuiCloud@163.com
 * @Function 关于数组的相关问题
 */

fun intersect1(nums1: IntArray, nums2: IntArray): IntArray {
    val list = mutableListOf<Int>()
    val numList = nums2.toMutableList()
    nums1.forEach {
        if (numList.contains(it)) {
            list.add(it)
            numList.remove(it)
        }
    }
    return list.toIntArray()
}

fun intersect2(nums1: IntArray, nums2: IntArray): IntArray {
    val maxSum: MutableList<Int>
    val minSum: IntArray
    if (nums1.size > nums2.size) {
        maxSum = nums1.toMutableList()
        minSum = nums2
    } else {
        maxSum = nums2.toMutableList()
        minSum = nums1
    }
    val list = mutableListOf<Int>()
    minSum.forEach {
        if (maxSum.contains(it)) {
            list.add(it)
            maxSum.remove(it)
        }
    }
    return list.toIntArray()
}


fun main() {
    //736-702
    val sum1 = intArrayOf(1, 2, 2, 1)
    val sum2 = intArrayOf(2, 2)
    val time = System.currentTimeMillis()
    (0..10000000).forEach {
        intersect1(sum1, sum2)
    }
    println(System.currentTimeMillis() - time)
}