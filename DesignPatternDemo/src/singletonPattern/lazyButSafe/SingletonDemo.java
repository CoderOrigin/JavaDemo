package singletonPattern.lazyButSafe;

/**
 * @author Gao Yuan
 * @date 2019-10-06 - 20:04
 */

public class SingletonDemo {
    private SingletonDemo instance;

    private SingletonDemo() {}

    public synchronized SingletonDemo getInstance() {
        if (instance == null) {
            instance = new SingletonDemo();
        }
        return instance;
    }
}
