package likou

/**
 * @Author petterp
 * @Date 2020/8/26-10:17 上午
 * @Email ShiyihuiCloud@163.com
 * @Function 自定义链表数据结构
 */
class LinkedList<E> {
    private var size = 0

    //虚拟头结点
    var dummyHead: Node<E> = Node(null, null)

    class Node<E>(var e: E? = null, var next: Node<E>? = null) {
        override fun toString(): String {
            return e?.toString() ?: ""
        }
    }

    /** 添加链表头元素 */
    fun addFirst(e: E) {
        addIndexed(0, e)
    }

    /** 移除链表头 O(1)*/
    fun removeFirst(): E? {
        return removeIndexed(0)
    }

    /** 移除链表尾 0(n) */
    fun removeLast(): E? {
        return removeIndexed(size - 1)
    }

    /** 删除指定位置下标元素 */
    fun removeIndexed(index: Int): E? {
        if (index > size || index < 0) throw RuntimeException("指定位置长度不得超过现有链表长度")
        var node = dummyHead
        //找到待删除节点之前的节点
        (0 until index).forEach { _ ->
            node.next?.let {
                node = it
            }
        }
        val retNode = node.next
        node.next = retNode?.next
        retNode?.next = null
        --size
        return retNode?.e
    }

    

    /** 在链表指定位置添加元素 */
    fun addIndexed(index: Int, e: E) {
        if (index > size || index < 0) throw RuntimeException("指定位置长度不得超过现有链表长度")
        if (index == 0) {
            dummyHead = Node(e, dummyHead.next)
            return
        }
        var temp = dummyHead
        dummyHead= add(index, temp.next)!!
    }

    private fun add(index: Int, node: Node<E>?): Node<E>? {
        if (index == 0) {
            return node
        }
        node?.next = add(index - 1, node?.next)
        return node?.next
    }

    /** 尾结点添加 */
    fun addLast(e: E) {
        addIndexed(size, e)
    }

    /** 返回链表是否为null  */
    fun isEmpty(): Boolean {
        return size == 0
    }

    /** 获取指定位置元素 */
    fun get(index: Int): E {
        if (index > size || index < 0) throw RuntimeException("指定位置长度不得超过现有链表长度")
        var cur = dummyHead.next
        (0 until index).forEach { _ ->
            cur = cur?.next
        }
        return cur!!.e!!
    }

    /** 获取首元素 */
    fun getFirst(): E {
        return get(0)
    }

    /** 获取尾元素 */
    fun getLast(): E {
        return get(size - 1)
    }

    /** 更新指定位置e */
    fun set(index: Int, e: E) {
        if (index > size || index < 0) throw RuntimeException("指定位置长度不得超过现有链表长度")
        var node = dummyHead.next
        (0 until index).forEach { _ ->
            node = node?.next
        }
        node?.e = e
    }

    fun getSize(): Int {
        return size
    }

    /** 判断是否存在指定元素 */
    fun contains(e: E): Boolean {
        var node = dummyHead.next
        while (node != null) {
            if (node.e === e)
                return true
            node = node.next
        }
        return false
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder("开始--- [")
        var next = dummyHead.next
        while (next != null) {
            stringBuilder.append("${next.e},")
            next = next.next
        }
        if (size > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length - 1)
        }
        return stringBuilder.append("]--- 结束").toString()
    }

}

fun main() {
    val linkedList = LinkedList<Int>()
    linkedList.addFirst(123)
    linkedList.addFirst(123)
    linkedList.addFirst(123)
    linkedList.addFirst(123)
    linkedList.addIndexed(0, 3)
    linkedList.addIndexed(3, 999)
    println(linkedList.toString())

    println("判断是否存在：123 " + linkedList.contains(123))

    linkedList.removeIndexed(0)
    println("删除指定位置元素后$linkedList")


}