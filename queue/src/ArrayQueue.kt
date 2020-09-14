/**
 * @Author petterp
 * @Date 2020/8/24-10:58 上午
 * @Email ShiyihuiCloud@163.com
 * @Function 自定义队列
 */
class ArrayQueue<E>(private val initialCapacity: Int=10) : Queue<E> {

    private var array = ArrayList<E>(initialCapacity)

    override fun enqueue(e: E) {
        array.add(e)
    }

    /** 移除队首元素 */
    override fun dequeue(): E {
        return array.removeFirst()
    }

    /** 查看队首元素 */
    override fun getFront(): E {
        return array.first()
    }

    override fun getSize(): Int {
        return array.size
    }

    override fun isEmpty(): Boolean {
        return array.isEmpty()
    }

    override fun toString(): String {
        val res = StringBuilder()
        res.append("Queue：")
        res.append("front [")
        if (array.isNotEmpty()) {
            array.forEach {
                res.append(it)
                res.append(",")
            }
            res.deleteCharAt(res.length - 1);
        }
        res.append("] tail")
        return res.toString()
    }

    fun getCapacity(): Int {
        return initialCapacity
    }

}

fun main() {
    val queue = ArrayQueue<Int>(10)
    (0..10).forEachIndexed { index, i ->
        queue.enqueue(index)
        println(queue.toString())
        if (i % 3 == 2) {
            queue.dequeue()
            println(queue.toString())
        }
    }
    println(queue.toString())
}

