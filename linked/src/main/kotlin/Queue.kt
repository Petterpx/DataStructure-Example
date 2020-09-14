/**
 * @Author petterp
 * @Date 2020/8/24-10:00 上午
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
interface Queue<E> {
    fun enqueue(e: E)

    fun dequeue(): E?

    fun getFront(): E?

    fun getSize(): Int

    fun isEmpty(): Boolean
}