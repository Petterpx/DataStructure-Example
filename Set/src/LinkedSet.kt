import java.util.*

/**
 * @Author petterp
 * @Date 2020/9/16-9:50 上午
 * @Email ShiyihuiCloud@163.com
 * @Function 使用链表实现Set
 */
class LinkedSet<E> : Set<E> {
    private val sets = LinkedList<E>()
    override fun add(e: E) {
        if (!sets.contains(e)) {
            sets.add(e)
        }
    }

    override fun remove(e: E) {
        sets.remove(e)
    }

    override fun contains(e: E): Boolean =
        sets.contains(e)

    override fun getSize(): Int = sets.size

    override fun isEmpty(): Boolean = sets.isEmpty()

}