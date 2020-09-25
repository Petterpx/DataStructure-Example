/**
 * @Author petterp
 * @Date 2020/9/20-8:52 上午
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
interface Map<K, V> {
    fun put(key: K, value: V)

    fun remove(key: K): V?

    fun contains(key: K): Boolean

    fun get(key: K): V?

    fun set(key: K, value: V)

    fun getSize(): Int

    fun isEmpty(): Boolean
}