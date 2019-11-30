package singletonPattern.staticInnerClassLoader;

/**
 * @author Gao Yuan
 * @date 2019-10-06 - 20:13
 */
/*
静态内部类不会在单例的时候加载，而是会在调用getInstance的时候才会进行第一次加载
 */
public class SingletonDemo {

    private static class SingletonDemoHolder {
        private static SingletonDemo instance= new SingletonDemo();
    }

    private SingletonDemo() {
        System.out.println("单例已经被加载");
    }

    public SingletonDemo getInstance() {
        return SingletonDemoHolder.instance;
    }
}
