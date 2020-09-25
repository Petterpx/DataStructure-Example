/**
 * @Author petterp
 * @Date 2020/8/23-8:00 上午
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
interface Stack<E> {
    fun getSize(): Int
    fun isEmpty(): Boolean
    fun pop(): E
    fun peek(): E
}