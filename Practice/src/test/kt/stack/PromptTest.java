package kt.stack;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import static java.sql.DriverManager.println;

/**
 * @Author petterp
 * @Date 2020/11/15-11:42 上午
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
public class PromptTest implements TestRule {
    public Statement apply(Statement statement, Description description) {
        // 获取测试方法的名字
        String methodName = description.getMethodName();
        //相当于 @Before
        println(methodName + "测试开始前！");

        // 运行的测试方法
        try {
            statement.evaluate();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        //运行结束，相当于@After
        println(methodName + "测试结束！");
        return statement;
    }
}
