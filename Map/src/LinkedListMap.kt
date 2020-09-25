import java.lang.IllegalArgumentException

/**
 * @Author petterp
 * @Date 2020/9/20-9:11 上午
 * @Email ShiyihuiCloud@163.com
 * @Function 使用链表实现map
 */
class LinkedListMap<K, V> : Map<K, V> {
    class Node<K, V> {
        var key: K? = null
        var value: V? = null
        var next: Node<K, V>? = null

        constructor(key: K?, value: V?, next: Node<K, V>?) {
            this.key = key
            this.value = value
            this.next = next
        }

        constructor(key: K?) : this(key, null, null)

        constructor() : this(null, null, null)


        override fun toString(): String {
            return "[${key.toString()}:${value.toString()}]"
        }
    }

    private var dummyHead: Node<K, V> = Node()
    private var size = 0


    private fun getNode(key: K): Node<K, V>? {
        var cur = dummyHead
        while (cur.next != null) {
            if (cur.next?.key == key) return cur.next
            cur = cur.next!!
        }
        return null
    }

    override fun put(key: K, value: V) {
        val node = getNode(key)
        node?.let {
            it.value = value
            return
        }
        dummyHead.next = Node(key, value, dummyHead.next)
        ++size
    }


    override fun remove(key: K): V? {
        var prev = dummyHead
        while (prev.next != null) {
            if (prev.next?.key == key)
                break
            prev = prev.next!!
        }
        if (prev.next != null) {
            val delNode = prev.next
            prev.next = delNode?.next
            delNode?.next = null
            --size
            return delNode?.value
        }
        return null
    }

    override fun contains(key: K): Boolean =
        getNode(key) != null

    override fun get(key: K): V? {
        return getNode(key)?.value
    }

    override fun set(key: K, value: V) {
        val node = getNode(key)
        node?.let {
            it.value = value
        } ?: throw IllegalArgumentException("key not Null!")
    }

    override fun getSize(): Int = size

    override fun isEmpty(): Boolean = size == 0

    override fun toString(): String {
        var node = dummyHead
        val builder = StringBuilder()
        while (node.next != null) {
            builder.append(node.next.toString()).append(",")
            node = node.next!!
        }
        if (builder.isNotEmpty()) builder.deleteCharAt(builder.length - 1)

        return builder.toString()
    }
}

fun main() {
    val map = LinkedListMap<String, String>()
    map.put("key", "123")
    map.put("key1", "123")
    map.put("key2", "123")
    println("当前map：$map")
    println("存入 key-123,value-56")
    map.put("123", "56")
    println("当前map：$map")
    map.remove("key")
    println("删除key=key：$map")
    println("是否包含key=123：" + map.contains("123"))
    println("当前长度：" + map.getSize() + "-----当前是否为null：" + map.isEmpty())
    println("最终map:$map")
}