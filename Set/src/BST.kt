import java.util.*
import kotlin.collections.ArrayList

/**
 * @Author petterp
 * @Date 2020/9/9-8:40 下午
 * @Email ShiyihuiCloud@163.com
 * @Function 二分搜索树
 */

// TODO: 2020/9/9 类型E必须具有可比较性
class BST<E : Comparable<E>> {
    class Node<E>(
        var e: E,
        var left: Node<E>? = null,
        var right: Node<E>? = null
    )

    private var root: Node<E>? = null
    private var size = 0

    fun size(): Int = size

    fun isEmpty() = size == 0

    // TODO: 2020/9/9 暂时不包含重复元素，如果考虑元素重复，更改相应的条件即可
    //  即 node.e<=e或者 node.e>=e
    fun add(e: E) {
        root = add(root, e)
    }

    private fun add(node: Node<E>?, e: E): Node<E> {
        if (node == null) {
            ++size
            return Node(e)
        }
        if (node.e > e)
            node.left = add(node.left, e)
        else if (node.e < e)
            node.right = add(node.right, e)
        return node
    }

    fun contains(e: E): Boolean {
        return contains(root, e)
    }

    /** 前序遍历 */
    fun prologue() {
        prologue(root)
    }

    fun preOrderNR() {
        val stack = Stack<Node<E>>()
        stack.push(root)
        while (stack.isNotEmpty()) {
            val cur = stack.pop()
            println(cur.e)
            cur.left?.let {
                stack.push(it)
            }
            cur.right?.let {
                stack.push(it)
            }
        }
    }

    /** 中序遍历 */
    fun inOrder() {
        inOrder(root)
    }

    /** 后序遍历 */
    fun postSequence() {
        postSequence(root)
    }

    private fun prologue(node: Node<E>?) {
        if (node == null) return
        println(node.e)
        prologue(node.left)
        prologue(node.right)
    }


    private fun inOrder(node: Node<E>?) {
        if (node == null) {
            return
        }
        inOrder(node.left)
        println(node.e)
        inOrder(node.right)
    }

    private fun postSequence(node: Node<E>?) {
        if (node == null) return
        postSequence(node.left)
        postSequence(node.right)
        println(node.e)
    }

    /** 是否包含指定元素 */
    private fun contains(node: Node<E>?, e: E): Boolean {
        if (node == null) return false
        return when {
            node.e == e -> {
                return true
            }
            node.e < e -> {
                contains(node.left, e)
            }
            else -> {
                contains(node.right, e)
            }
        }
    }

    override fun toString(): String {
        val arrayList = getBstList(root, 0, ArrayList())
        val stringBuilder = StringBuilder()
        var size = arrayList.size
        arrayList.forEach { linkedList ->
            val spec = StringBuilder()
            (0 until size).forEach { _ ->
                spec.append("-")
            }
            stringBuilder.append(spec)
            while (!linkedList.isEmpty()) {
                stringBuilder.append(linkedList.removeFirst()).append(",")
            }
            stringBuilder.deleteCharAt(stringBuilder.length - 1)
            stringBuilder.append(spec)
            --size
            stringBuilder.append("\n")
        }
        return stringBuilder.toString()
    }

    private fun addSpec(height: Int, res: String = "*"): String {
        val stringBuilder = StringBuilder()
        (0..height).forEach { _ ->
            stringBuilder.append(res)
        }
        return stringBuilder.toString()
    }

    /** 遍历当前树，合成相应的list
     *  当存在[*]时，代表其是右子树，并且其左子树为null
     * */
    private fun getBstList(
        node: Node<E>?,
        height: Int,
        arrayList: ArrayList<LinkedList<String>>
    ): ArrayList<LinkedList<String>> {
        //如果当前高度为null,就新增一个子list
        if (arrayList.size <= height) {
            arrayList.add(LinkedList())
        }

        if (node == null) {
            val nullLists = arrayList[height]
            nullLists.add("null")
            return arrayList
        }

        //拿到子list，开始增加
        val lists = arrayList[height]

        //计算什么位置时增加下标
        // TODO: 2020/9/12 逻辑问题

        lists.add(node.e.toString())

        getBstList(node.left, height + 1, arrayList)
        getBstList(node.right, height + 1, arrayList)
        return arrayList
    }

    /** 寻找树的最小元素-递归,最大元素同理 */
    fun minimumRecursion(): E {
        if (size == 0 || root == null) throw IllegalArgumentException("BST is empty!")
        return minimum(root!!).e
    }

    /** 寻找树最小元素-while，最大元素同理 */
    fun minimum(): E? {
        var node = root
        while (node?.left != null) {
            node = node.left
        }
        return node?.e
    }

    /** 寻找最小元素的节点 */
    private fun minimum(node: Node<E>): Node<E> {
        return node.left?.let {
            minimum(it)
        } ?: node
    }

    /** 从二分搜索树删除最小值所在节点,调整当前树，并返回最小值 */
    fun removeMin(): E {
        val ret = minimumRecursion()
        root = removeMin(root)
        return ret
    }

    /** 删除以Node为根的二分搜索树中的最小节点
     *  返回删除节点后新的二分搜索树的根
     *  相应删除最大节点，同理
     * */
    private fun removeMin(node: Node<E>?): Node<E>? {
        if (node?.left == null) {
            val rightNode = node?.right
            node?.right = null
            --size
            return rightNode
        }
        node.left = removeMin(node.left)
        return node
    }

    fun levelOrder() {
        val q = LinkedList<Node<E>>()
        root?.let { q.add(it) }
        while (!q.isEmpty()) {
            val node = q.remove()
            node?.left?.let {
                q.add(it)
            }
            node?.right?.let {
                q.add(it)
            }
        }
    }

    /** 删除指定元素 */
    fun remove(e: E) {
        root = remove(root, e)
    }

    /**
     * 删除以node 为根的二分搜索树种值为e的节点
     * 返回 删除节点后新的二分搜索树的根
     * */
    private fun remove(node: Node<E>?, e: E): Node<E>? {
        if (node == null) return node
        if (node.e < e) {
            remove(node.right, e)
        } else if (node.e > e) {
            remove(node.left, e)
        } else {
            if (node.left == null) {
                val rightNode = node.right
                node.right = null
                --size
                return rightNode
            }

            if (node.right == null) {
                val leftNode = node.left
                node.left = null
                --size
                return leftNode
            }

            if (node.right == null && node.left == null) return null
        }

        //找到待删除节点左右子树均不为null的情况
        //找到比待删除节点大的最小节点，即删除节点右子树的最小节点
        // 用这个节点替代删除节点的位置
        val nodeSuccess = minimum(node.right!!)
        nodeSuccess.left = node.left
        nodeSuccess.right = removeMin(node.right)
        return nodeSuccess
    }

}


fun main() {
//    val bst = BST<Int>()
//    bst.add(41)
//    bst.add(22)
//    bst.add(58)
//    bst.add(15)
//    bst.add(33)
//    bst.add(50)
//    bst.add(42)
//    println(bst.toString())
//    bst.remove(41)
//    println(bst.toString())


}


