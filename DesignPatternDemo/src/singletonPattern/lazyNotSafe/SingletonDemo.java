package singletonPattern.lazyNotSafe;

/**
 * @author Gao Yuan
 * @date 2019-10-06 - 19:59
 */

/*
两个线程同时调用getInstance时会出现线程安全问题，创建多个对象
 */
public class SingletonDemo {
    private SingletonDemo instance;

    private SingletonDemo() {}

    public SingletonDemo getInstance() {
        if (instance == null) {
            instance = new SingletonDemo();
        }
        return instance;
    }

}
