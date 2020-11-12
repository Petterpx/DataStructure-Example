import java.lang.StringBuilder

/**
 * @Author petterp
 * @Date 2020/11/10-10:33 下午
 * @Email ShiyihuiCloud@163.com
 * @Function 大数相加
 */

private fun addString(num1: String, num2: String): String {

    val result = StringBuilder()
    //反转两个数字
    val builder1 = StringBuilder(num1).reverse()
    val builder2 = StringBuilder(num2).reverse()
    val len1 = builder1.length
    val len2 = builder2.length
    //找到最长的length
    val maxLength = if (len1 > len2) len1 else len2

    var c = 0

    //开始进行补位，对短的String进行补位
    //如果最长的是str1,则对str进行补位
    if (len1 < len2) {
        var temp1 = len1
        while (temp1 < len2) {
            builder1.append("0")
            temp1++
        }
    } else if (len1 > len2) {
        var temp2 = len2
        while (temp2 < len1) {
            builder2.append("0")
            temp2++
        }
    }

//    println("源数据str1-$str1")
//    println("补位+反转后-$builder1")
//    println("源数据str2-$str2")
//    println("补位+反转后-$builder2")

    //遍历添加 注意Integer.parseInt(builder1[it].toString()) 的写法
    //每次记录进位的值，c
    (0 until maxLength).forEach {
        val nSum = Integer.parseInt(builder1[it].toString()) + Integer.parseInt(builder2[it].toString()) + c
        val ap = nSum % 10
        result.append(ap)
        c = nSum / 10
    }

    //最后别忘了对c进行再次进位判断
    if (c > 0) result.append(c)
    return result.reverse().toString()
}