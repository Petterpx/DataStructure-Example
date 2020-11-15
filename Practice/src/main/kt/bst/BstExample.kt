package kt.bst

import java.util.*
import kotlin.collections.ArrayList

/**
 * @Author petterp
 * @Date 2020/11/15-8:52 下午
 * @Email ShiyihuiCloud@163.com
 * @Function 二叉树相关
 */

class Node<E : Comparable<E>>(var e: E) {
    var left: Node<E>? = null
    var right: Node<E>? = null
}

/** dfs-层序遍历
 * 解法思路：其实是一个前序遍历，不过在数据存入时，存到了相应的list
 * */
fun dfsTraverse(root: Node<Int>?): List<List<Int>>? {
    return root?.let {
        val arrayList: ArrayList<ArrayList<Int>> = ArrayList()
        dfsTraverse(root, arrayList, 0)
        arrayList
    }
}

private fun dfsTraverse(node: Node<Int>?, list: ArrayList<ArrayList<Int>>, level: Int) {
    node?.let {
        if (list.size == level) {
            list.add(ArrayList())
        }
        list[level].add(it.e)
        dfsTraverse(node.left, list, level + 1)
        dfsTraverse(node.right, list, level + 1)
    }
}


/** bfs-层序遍历
 * 解法思路：利用队列，将每一层的所有node存入，接着开始遍历，遍历过程中继续存入node
 * 从而达到对整个二叉树的全部按序存入
 * */
fun bfsTraverse(root: Node<Int>?): List<List<Int>>? {
    return root?.let { it ->
        val arrayList: ArrayList<ArrayList<Int>> = ArrayList()
        val queue = LinkedList<Node<Int>>()
        queue.add(it)
        while (queue.isNotEmpty()) {
            var count = queue.size
            val tempList = ArrayList<Int>()
            while (count > 0) {
                val temp = queue.pop()
                tempList.add(temp.e)
                temp.left?.let {
                    queue.add(it)
                }
                temp.right?.let {
                    queue.add(it)
                }
                --count
            }
            arrayList.add(tempList)
        }
        arrayList
    }
}

