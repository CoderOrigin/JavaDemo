package singletonPattern.enumerationMethod;

/**
 * @author Gao Yuan
 * @date 2019-10-06 - 20:18
 */

/*
摘抄：
Effective Java作者Josh Bloch 提倡的方式，在我看来简直是来自神的写法。解决了以下三个问题：
(1)自由串行化。
(2)保证只有一个实例。
(3)线程安全。
Josh Bloch 对这个方法的评价：
这种写法在功能上与共有域方法相近，但是它更简洁，无偿地提供了串行化机制，绝对防止对此实例化，即使是在面对复杂的串行化或者反射攻击的时候。
虽然这中方法还没有广泛采用，但是单元素的枚举类型已经成为实现Singleton的最佳方法。
枚举单例这种方法问世以来，许多分析文章都称它是实现单例的最完美方法——写法超级简单，而且又能解决大部分的问题。
不过我个人认为这种方法虽然很优秀，但是它仍然不是完美的——比如，在需要继承的场景，它就不适用了。
 */
enum SingletonDemo {
    INSTANCE;
    public void otherMethod() {
        System.out.println("执行了其他方法");
    }
}
