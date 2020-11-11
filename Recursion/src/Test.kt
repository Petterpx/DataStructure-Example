/**
 * @Author petterp
 * @Date 2020/9/2-8:30 上午
 * @Email ShiyihuiCloud@163.com
 * @Function
 */

fun addDigits(num: Int): Int {
    var temp = num
    if (temp > 9) {
        temp = num % 9
        if (temp == 0) return 9
    }
    return temp
}

fun main() {
    println(addDigits(98))
}