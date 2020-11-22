package kt

import java.lang.StringBuilder

/**
 * @Author petterp
 * @Date 2020/11/22-5:57 下午
 * @Email ShiyihuiCloud@163.com
 * @Function
 *
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val pre = ListNode(0)
        var cur: ListNode? = pre
        var sum = 0
        var temp1 = l1
        var temp2 = l2
        while (temp1 != null || temp2 != null) {
            sum += (temp1?.`val` ?: 0) + (temp2?.`val` ?: 0)
            cur?.next = ListNode(sum % 10)
            cur = cur?.next
            sum /= 10
            temp1 = temp1?.next
            temp2 = temp2?.next
        }
        if (sum != 0) {
            cur?.next = ListNode(sum)
        }
        return pre.next
    }
}

private fun toString(l1: ListNode?): String {
    return l1?.let {
        val builder = StringBuilder()
        var t: ListNode? = it
        while (t != null) {
            builder.append("${t.`val`},")
            t = t.next
        }
        if (builder.isNotEmpty()) builder.deleteCharAt(builder.length - 1)
        builder.toString()
    } ?: ""
}

private fun add(vararg sums: Int): ListNode? {
    val pre = ListNode(0)
    var cur: ListNode? = pre
    sums.forEach {
        cur?.next = ListNode(it)
        cur = cur?.next
    }
    return pre.next
}

fun main() {
    println(toString(Solution().addTwoNumbers(add(1, 2, 3), add(1, 2, 3))))
}