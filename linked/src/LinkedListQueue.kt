/**
 * @Author petterp
 * @Date 2020/8/29-4:23 下午
 * @Email ShiyihuiCloud@163.com
 * @Function 链表队列
 */
class LinkedListQueue<E> : Queue<E> {

    private var size = 0
    private var head: Node<E>? = null
    private var tail: Node<E>? = null

    private class Node<E>(var e: E? = null, var next: Node<E>? = null) {
        override fun toString(): String {
            return e?.toString() ?: ""
        }
    }

    override fun enqueue(e: E) {
        tail?.let {
            tail?.next = Node(e)
            tail = tail?.next
        } ?: tailNull(e)
        ++size
    }

    private fun tailNull(e: E) {
        tail = Node(e)
        head = tail
    }

    override fun dequeue(): E? {
        if (head == null) throw NullPointerException("head !=null!!")
        val node = head
        head = head?.next
        node?.next = null
        --size
        if (head == null) tail = null
        return node?.e
    }

    override fun getFront(): E? {
        if (head == null) throw NullPointerException("head !=null!!")
        return head?.e
    }

    override fun getSize(): Int {
        return size
    }

    override fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder("开始--- [")
        var next = head
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
    val likedlistQueue = LinkedListQueue<Int>()
    likedlistQueue.enqueue(1)
    likedlistQueue.enqueue(2)
    likedlistQueue.enqueue(3)
    println(likedlistQueue.toString())
    likedlistQueue.dequeue()
    println(likedlistQueue.toString())
}