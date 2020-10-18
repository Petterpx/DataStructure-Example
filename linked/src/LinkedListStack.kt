import java.lang.StringBuilder

/**
 * @Author petterp
 * @Date 2020/8/29-3:55 下午
 * @Email ShiyihuiCloud@163.com
 * @Function 链表栈
 */
class LinkedListStack<E> : Stack<E> {

    private val linkedList by lazy {
        LinkedList<E>()
    }

    override fun getSize(): Int {
        return linkedList.getSize()
    }

    override fun isEmpty(): Boolean {
        return linkedList.isEmpty()
    }

    override fun pop(): E? {
        return linkedList.removeFirst()
    }

    override fun peek(): E {
        return linkedList.getFirst()
    }

    override fun toString(): String {
        val res = StringBuilder()
        res.append("Stack:Pop-")
        res.append(linkedList)
        return res.toString()

    }

    override fun push(e: E) {
        linkedList.addFirst(e)
    }
}

fun main() {
    val linkedListStack = LinkedListStack<Int>()
    linkedListStack.push(1)
    linkedListStack.push(2)
    linkedListStack.push(3)
    println(linkedListStack.toString())
    linkedListStack.pop()
    println(linkedListStack.toString())
}