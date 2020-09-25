import kotlin.concurrent.thread

/**
 * @Author petterp
 * @Date 2020/8/22-10:09 上午
 * @Email ShiyihuiCloud@163.com
 * @Function
 */
class StackTest {
    fun a() {
        println("Stack-fun-a进入")
        b()
        println("Stack-fun-b移除")
    }

    private fun b() {
        println("Stack-fun-b进入")
        c()
        println("Stack-fun-c移除")
    }

    private fun c() {
        println("Stack-fun-c进入")
    }
}

fun main() {
//    StackTest().a()
    TestDoubleThreadStack().a()
    println("Stack-fun-a移除")
}

class TestDoubleThreadStack {
    fun a() {
        println("当前线程--${Thread.currentThread()}------Stack-fun-a进入")
        thread {
            b()
            println("当前线程--${Thread.currentThread()}------Stack-fun-b移除")
        }
        c()
        println("当前线程--${Thread.currentThread()}---Stack-fun-c移除")
    }

    fun b() {
        println("当前线程--${Thread.currentThread()}---Stack-fun-b进入")
    }

    fun c() {
        println("当前线程--${Thread.currentThread()}----Stack-fun-c进入")
        d()
    }

    fun d() {
        println("当前线程--${Thread.currentThread()}----Stack-fun-d进入")
    }
}