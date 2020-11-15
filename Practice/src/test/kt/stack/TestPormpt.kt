import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

/**
 * @Author petterp
 * @Date 2020/11/15-11:36 上午
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
 class TestPormpt : TestRule {
    override fun apply(statement: Statement, description: Description): Statement {

        // 获取测试方法的名字
        val methodName: String = description.methodName
        //相当于 @Before
        println(methodName + "测试开始前！")

        // 运行的测试方法
        statement.evaluate()

        //运行结束，相当于@After
        println(methodName + "测试结束！")
        return statement
    }
}