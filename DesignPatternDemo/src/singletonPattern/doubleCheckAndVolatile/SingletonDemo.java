package singletonPattern.doubleCheckAndVolatile;

/**
 * @author Gao Yuan
 * @date 2019-10-06 - 20:28
 */

/*
如果不用volatile有小概率会出现线程安全问题
STEP 1. 线程A访问getInstance()方法，因为单例还没有实例化，所以进入了锁定块。
STEP 2. 线程B访问getInstance()方法，因为单例还没有实例化，得以访问接下来代码块，而接下来代码块已经被线程1锁定。
STEP 3. 线程A进入下一判断，因为单例还没有实例化，所以进行单例实例化，成功实例化后退出代码块，解除锁定。
STEP 4. 线程B进入接下来代码块，锁定线程，进入下一判断，因为已经实例化，退出代码块，解除锁定。
STEP 5. 线程A获取到了单例实例并返回，线程B没有获取到单例并返回Null。

但是如果加上了volatile，A实例化之后，在B获取的时候，instance已经被刷新到主内存中了。

还有，这里的private static volatile Singleton singleton = null;中的volatile也必不可少，volatile关键字可以防止jvm指令重排优化，

    因为 singleton = new Singleton() 这句话可以分为三步：
         1. 为 singleton 分配内存空间；
         2. 初始化 singleton；
         3. 将 singleton 指向分配的内存空间。
         但是由于JVM具有指令重排的特性，执行顺序有可能变成 1-3-2。 指令重排在单线程下不会出现问题，
         但是在多线程下会导致一个线程获得一个未初始化的实例。例如：线程T1执行了1和3，此时T2调用 getInstance() 后
         发现 singleton 不为空，因此返回 singleton， 但是此时的 singleton 还没有被初始化。
         使用 volatile 会禁止JVM指令重排，从而保证在多线程下也能正常执行。
————————————————
版权声明：本文为CSDN博主「yuan_qh」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/yuan_qh/article/details/99962482
 */
public class SingletonDemo {
    private static volatile SingletonDemo instance;

    private SingletonDemo() {
    }

    public SingletonDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }
}
