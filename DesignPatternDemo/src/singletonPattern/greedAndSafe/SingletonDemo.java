package singletonPattern.greedAndSafe;

/**
 * @author Gao Yuan
 * @date 2019-10-06 - 20:11
 */
public class SingletonDemo {
    private SingletonDemo instance;

    private SingletonDemo() {
    }

    public SingletonDemo getInstance() {
        return  instance;
    }
}
