/**
 * @Author petterp
 * @Date 2020/9/17-8:38 上午
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
interface Set<E> {
    fun add(e: E)

    fun remove(e: E)

    fun contains(e: E): Boolean

    fun getSize():Int

    fun isEmpty():Boolean
}