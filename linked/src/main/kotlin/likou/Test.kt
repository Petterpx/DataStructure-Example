package likou

/**
 * @Author petterp
 * @Date 2020/9/1-9:55 上午
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
//删除指定链表的某个节点
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {


    fun addNode(): ListNode {
        var node: ListNode? = null
        (0..4).forEach {
            val temp = ListNode(it)
            temp.next = node
            node = temp
        }
        return node!!
    }

    fun toString(node: ListNode): String {
        val stringBuilder = StringBuilder("开始--- [")
        var next = node.next
        while (next != null) {
            stringBuilder.append("${next.`val`},")
            next = next.next
        }
        return stringBuilder.append("]--- 结束").toString()
    }

    fun deleteNode(head: ListNode?, `val`: Int): ListNode? {
        if (head == null) return null
        head.next=deleteNode(head.next, `val`)
        if (head.`val`==`val`)
            return head.next
        return head
    }
}

fun main() {
    val solution = Solution()
    val node = solution.addNode()
    println(solution.toString(node))

    println("删除 2")
    solution.deleteNode(node, 1)
    println(solution.toString(node))

}