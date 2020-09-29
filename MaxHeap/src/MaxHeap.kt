/**
 * @Author petterp
 * @Date 2020/9/25-8:54 上午
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
class MaxHeap<E : Comparable<E>>(capacity: Int = 8) {
    private var data = ArrayList<E>(capacity)

    //返回堆中元素个数
    private val size: Int
        get() {
            return data.size
        }

    //堆中是否为null
    fun isEmpty() = data.isEmpty()

    //返回完全二叉树的数组表示中，指定索引元素的父节点索引
    fun parent(index: Int): Int {
        if (index == 0) throw IllegalArgumentException("index-0 doesn't have parent.")
        return (index - 1) / 2
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点索引
    fun leftChild(index: Int) = index * 2 + 1

    //返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点索引
    fun rightChild(index: Int) = index * 2 + 2

    //向堆中添加元素
    fun add(e: E) {
        data.add(e)
        //重新对元素进行上浮
        siftUp(size - 1)
    }

    //元素交换
    private fun swap(i: Int, j: Int) {
        if (i < 0 || j >= size || j < 0 || j >= size) throw IllegalArgumentException("Index is illegal.")
        val t = data[i]
        data[i] = data[j]
        data[j] = t
    }


    //获取堆中最大的元素
    fun findMax(): E {
        if (size == 0) throw IllegalArgumentException()
        return data[0]
    }

    //获取堆中最小的元素
    fun findMin(): E {
        if (size == 0) throw IllegalArgumentException()
        return data[size - 1]
    }

    //取出堆中最大元素
    @ExperimentalStdlibApi
    fun extractMax(): E {
        val max = findMax()
        //先将最小的元素与最大的元素位置互换,然后开始元素位置互换
        swap(0, size - 1)

        //先删除堆中末尾元素,也即是删除最大元素
        data.removeLast()
        siftDown(0)
        return max
    }

    //元素上浮，从底向上
    private fun siftUp(k: Int) {
        //如果当前节点不为0，并且其大于父元素，则进行更换
        if (k > 0 && data[parent(k)] < data[k]) {
            //获得父节点元素位置
            val parentIndex = parent(k)
            //交换父亲节点元素
            swap(k, parentIndex)
            //递归排序
            siftUp(parentIndex)
        }
    }

    //元素下浮，从顶向下
    private fun siftDown(k: Int) {
        //拿到左边元素
        var index = leftChild(k)
        //如果左孩子位置合适，并且右孩子大于左孩子，就将要调整的位置给右孩子
        if (index < size && data[index + 1] > data[index]) {
            index += 1
        }
        //如果当前元素大于
        if (data[k] > data[index]) return
        //移动元素位置
        swap(k, index)
        //递归继续尝试
        siftDown(index)
    }
}