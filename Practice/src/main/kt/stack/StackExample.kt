package stack

import java.util.*

/**
 * @Author petterp
 * @Date 2020/11/14-1:29 下午
 * @Email ShiyihuiCloud@163.com
 * @Function
 */


/** 等效括号
 *  如题：给定一个字符串所表示的括号序列，包含以下字符： '(', ')', '{', '}', '[' and ']'， 判定是否是有效的括号序列。
 *  括号必须依照 "()" 顺序表示， "()[]{}" 是有效的括号，但 "([)]" 则是无效的括号。
 *
 *  解法思路：
 *  使用栈存储，将字符串切割为char遍历，先存储指定方向的符号，如'(','{','['。
 *  如果属于右方向的，如'}'等，进入判断，如果栈顶符号与当前char相等并且栈不会null，即为正确，否则直接return false
 * */
fun isBrackets(s: String): Boolean {
    if (s.length < 2) return false
    val stack = Stack<Char>()
    s.forEach {
        if ("{([".contains(it)) {
            stack.push(it)
        } else {
            if (stack.isNotEmpty() && isBracketChart(stack.peek(), it)) {
                stack.pop()
            } else return false
        }
    }
    return stack.isEmpty()
}

private fun isBracketChart(str1: Char, str2: Char): Boolean =
    (str1 == '{' && str2 == '}') ||
            (str1 == '[' && str2 == ']') || (str1 == '(' && str2 == ')')


fun main() {
    println(isBrackets("{]"))
}

