import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import stack.isBrackets

/**
 * @Author petterp
 * @Date 2020/11/14-5:04 下午
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
@RunWith(Parameterized::class)
class StackExampleKtTest(private val str: Pair<String, Boolean>) {

    // TODO: 2020/11/15 相应的，这种处理方式也容易造成对错误的难以寻找
    companion object {
        @Parameterized.Parameters
        @JvmStatic
        fun primeStrings(): Collection<Pair<String, Boolean>> =
            listOf(
                "" to false,
                "{" to false,
                "{}" to false,
                "{[]}" to true,
                "asd{()}" to false
            )
    }

    @Test
    fun testIsBrackets() {
        assertEquals("出错了-当前 \"${str.first}\" to ${str.second}",
            str.second, isBrackets(str.first))
    }
}