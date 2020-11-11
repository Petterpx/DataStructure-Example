package sfo

import java.util.*


/**
 * @Author petterp
 * @Date 2020/11/11-9:07 下午
 * @Email ShiyihuiCloud@163.com
 * @Function
 */

/** 用两个栈实现队列
 * 剑指Offer-09
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * */
class Cqueue {

    val s1 = Stack<Int>()
    val s2 = Stack<Int>()

    fun appendTail(t: Int) {
        s1.push(t)
    }

    fun deleteHead(): Int {
        if (s2.isNotEmpty()) return s2.pop()
        if (s1.isEmpty()) return -1
        while (s1.isNotEmpty()) {
            s2.push(s1.pop())
        }
        return s2.pop()
    }


    override fun toString(): String {
        val builder = StringBuilder()
        var temp = deleteHead()
        while (temp != -1) {
            builder.append(temp).append("-")
            temp = deleteHead()
        }
        if (builder.isNotEmpty()) return builder.substring(0, builder.length - 1)
        return "null"
    }
}

fun main() {
    val stacks = Cqueue()
    stacks.appendTail(123)
    stacks.appendTail(12)
    stacks.appendTail(13)
    println(stacks)
}