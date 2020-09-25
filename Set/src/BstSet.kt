import java.util.*

/**
 * @Author petterp
 * @Date 2020/9/16-9:53 上午
 * @Email ShiyihuiCloud@163.com
 * @Function 使用二分搜索树写BST
 */
class BstSet<E : Comparable<E>>:Set<E> {
    private val sets = BST<E>()
    override fun add(e: E) {
        sets.add(e)
    }

    override fun remove(e: E) {
        sets.remove(e)
    }

    override fun contains(e: E): Boolean =
       sets.contains(e)


    override fun getSize(): Int =sets.size()

    override fun isEmpty(): Boolean =sets.isEmpty()

}