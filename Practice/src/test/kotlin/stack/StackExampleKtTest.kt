
import org.junit.Assert.*
import stack.isBrackets

/**
 * @Author petterp
 * @Date 2020/11/14-5:04 下午
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
class StackExampleKtTest {

    @org.junit.Test
    fun testIsBrackets() {
        assertTrue(isBrackets("{{}}"))
        assertFalse(isBrackets(""))
        assertTrue(isBrackets("{[{{}}]}"))
        assertTrue(isBrackets("{}"))
    }
}