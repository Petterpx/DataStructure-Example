/**
 * @Author petterp
 * @Date 2020/8/25-9:45 上午
 * @Email ShiyihuiCloud@163.com
 * @Function 循环队列
 */
class LoopQueue<E : Any>(private val capacity: Int = 10) : Queue<E?> {

    var data = arrayOfNulls<Any>(capacity + 1) as Array<E?>
    //队首下标
    private var front = 0
    //队尾下标
    private var tail = 0
    //当前数据长度
    private var size = 0
    //实际容量位置
    private var arraySize = data.size

    override fun enqueue(e: E?) {
        //大于数组长度，扩容
        if ((tail + 1) % arraySize == front) {
            resize(capacity * 2)
        }
        arraySize = data.size
        //入队
        data[tail] = e
        //确定队尾位置
        tail = (tail + 1) % arraySize
        //增加数据长度
        ++size
    }

    private fun resize(newCapacity: Int) {
        //扩容大小为传入容量+1，因为我们一定会浪费一个空间
        val newData = arrayOfNulls<Any>(newCapacity + 1) as Array<E?>
        //先确定当前容量大小
        arraySize = data.size
        //遍历旧数据源，存入新数组

        // it+front原因很简单，从 原队首 位置开始遍历相加
        (0..size).forEach {
            newData[it] = data[(it + front) % arraySize]
        }
        data = newData
        //新队首位置为0
        front = 0
        //新队尾位置为原数组的长度
        tail = size
    }

    override fun dequeue(): E? {
        if (isEmpty()) throw IllegalArgumentException("队列为null")
        val ret = data[front]
        data[front] = null
        front = (front + 1) % arraySize
        --size
        //缩容
        if (size == capacity / 4 && capacity / 2 != 0) resize(capacity / 2)
        return ret
    }


    override fun getFront(): E? {
        if (isEmpty()) throw IllegalArgumentException("队列为null")
        return data[front]
    }

    override fun getSize(): Int {
        return size
    }

    override fun isEmpty(): Boolean {
        return front == tail
    }

    override fun toString(): String {
        val res = StringBuilder().append("Queue：").append("front [")
        if (!isEmpty()) {
            //数据打印除重
            data.filterNotNull().forEach {
                res.append(it).append(",")
            }
            res.deleteCharAt(res.length - 1);
        }
        res.append("] tail")
        return res.toString()
    }
}

fun main() {
    val loopQueue = LoopQueue<Int>(4)
    (1..8).forEach {
        loopQueue.enqueue(it)
        println(loopQueue.toString())
        if (it % 3 == 0) {
            loopQueue.dequeue()
            println(loopQueue.toString())
        }
    }
}