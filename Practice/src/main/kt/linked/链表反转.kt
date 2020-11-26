package kt.linked

import java.util.*

/**
 * @Author petterp
 * @Date 2020/11/26-11:13 下午
 * @Email ShiyihuiCloud@163.com
 * @Function 反转链表
 */

class LinkedRing {

    /** 使用栈实现 */
    fun stackTo(head: ListNode?): ListNode? {
        return head?.let {
            val stack = Stack<ListNode>()
            var temp = head
            while (temp != null) {
                stack.push(temp)
                temp = temp.next
            }
            //如果栈为null,直接返回null
            if (stack.isEmpty()) return null
            var node = stack.pop()
            //头结点
            val dummy = node
            while (stack.isNotEmpty()) {
                val tempNode = stack.pop()
                node.next = tempNode
                node = node.next
            }
            //最后一个节点是反转前的头结点，注意next置null
            node.next = null
            dummy
        }
    }

    /**每次都访问的原链表节点都会成为新链表头结点
     * 示例插入的过程：
     * 比如链表，1->2->3->null，具体插入过程如下
     * 1. tempNode(1->2->3->null)
     *    temp=2->3->null
     *    tempNode.next(1->.next)=newHead(null)
     *    newHead(null)=tempNode(1->null)
     *    tempNode(1->2->3->null)=temp(2->3->null)
     *
     *    当前：newHead(1->null) tempNode(2->3->null)
     *
     * 2. tempNode(2->3->null)
     *    temp=3->null
     *    tempNode.next(2->.next)=newHead(1->null)
     *    newHead(1->null)=tempNode(2->1->null)
     *    tempNode(2->1->null)=temp(3->null)
     *
     *    当前：newHead(2-1->null) tempNode(3->null)
     * */
    fun reverseLinked(head: ListNode?): ListNode? {
        var newHead: ListNode? = null
        var tempNode = head
        while (tempNode != null) {
            //先保存访问节点的下一个节点，用于下一步访问
            val temp = tempNode.next
            //每次访问的原链表节点都会成为新链表的头结点
            tempNode.next = newHead
            //更新新链表
            newHead = tempNode
            //重新赋值，继续访问
            tempNode = temp
        }
        return newHead
    }


}