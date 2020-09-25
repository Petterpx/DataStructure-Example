/**
 * @Author petterp
 * @Date 2020/9/25-8:54 上午
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
class MaxHeap<E : Comparable<E>>(capacity: Int = 8) {
    private var data = ArrayList<E>(capacity)

    //返回堆中元素个数
    fun size() = data.size

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
}