/**
 * @Author petterp
 * @Date 2020/8/23-8:01 上午
 * @Email ShiyihuiCloud@163.com
 * @Function 自定义栈
 */

class ArrayStack<E>(private val capacity: Int = 6) : Stack<E> {

    private val array = ArrayList<E>(capacity)

    override fun getSize(): Int {
        return array.size
    }

    override fun isEmpty(): Boolean {
        return array.isEmpty()
    }

    override fun pop(): E {
        return array.removeLast()
    }

    override fun peek(): E {
        return array[getSize() - 1]
    }

    fun getCapacity(): Int {
        return capacity
    }

    fun push(e: E) {
        array.add(e)
    }

    override fun toString(): String {
        val res = StringBuilder("Stack:")
        res.append("Stack：").append("[")
        if (array.isNotEmpty()) {
            array.forEach {
                res.append("$it,")
            }
            res.deleteCharAt(res.length - 1)
        }
        res.append("] top ")
        return res.toString()
    }
}