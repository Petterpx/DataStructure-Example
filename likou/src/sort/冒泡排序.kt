package sort

/**
 * @Author petterp
 * @Date 2020/11/12-9:39 上午
 * @Email ShiyihuiCloud@163.com
 * @Function 冒泡排序
 */

//简单解释，包含两个操作原子，每次都需要交换去比较。
// TODO: 2020/11/12 对包含n个数据的数组进行冒泡排序，最坏情况下初始状态有序度是0，
//  需要进行n(n-1)/2次交换。最好情况下，初始状态有序度是n(n-1)/2，无需进行交换。
//  取中间值n(n-1)/4，表示初始有序的的平均情况。也就是平均情况下需要n(n-1)/4次交换操作，
//  比较操作肯定要比交换操作多，
//  而这个复杂度的上限是O(n²)，所以可粗略地认为冒泡排序平均情况下时间复杂度是O(n²)。
fun bubbleSort(sums: IntArray): IntArray {
    if (sums.isEmpty() || sums.size == 1) return sums
    val size = sums.size - 1
    //增加一个中间标志u，当前一轮没有进行交换时，则认为数组已经有序
    var swap: Boolean
    (0..size).forEach { i ->
        swap = false
        (0 until size - i).forEach {
            if (sums[it] > sums[it + 1]) {
                val temp = sums[it]
                sums[it] = sums[it + 1]
                sums[it + 1] = temp
                swap = true
            }
        }
        if (!swap) return sums
    }
    return sums
}




fun main() {
    val sums = intArrayOf(13, 546, 12, 546, 12, 34, 23)
    bubbleSort(sums).forEach {
        print("$it,")
    }
}

