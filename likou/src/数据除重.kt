import kotlin.collections.LinkedHashSet

/**
 * @Author petterp
 * @Date 2020/11/11-8:11 下午
 * @Email ShiyihuiCloud@163.com
 * @Function
 */


fun weightRemoval(str1: String): String {
    val set = LinkedHashSet<Char>()
    str1.forEach {
        set.add(it)
    }
    val builder = StringBuilder()
    set.forEach {
        builder.append(it)
    }
    return builder.toString()
}

fun main() {
    println(weightRemoval("1123AasasDASD"))
}