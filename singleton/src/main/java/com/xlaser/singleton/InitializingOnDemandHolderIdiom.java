package com.xlaser.singleton;

/**
 * JVM会保证一个类的构造器方法在多线程环境中被同步正确地加载,如果多个线程同时去初始化一个类，那么只有一个线程去执行.
 * 静态内部类的引用不会早于getInstance(),多线程调用时会触发SingletonHolder的构造方法调用,虚拟机这时保证构造方法的同步.
 *
 * @package: com.xlaser.singleton
 * @author: Elijah.D
 * @time: 2019/9/28 12:37
 * @description: 懒汉模式
 * @copyright: Copyright© 2019
 * @version: V1.0
 * @modified: Elijah.D
 */
public final class InitializingOnDemandHolderIdiom {
    /**
     * Private constructor.
     */
    private InitializingOnDemandHolderIdiom() {
    }

    /**
     * @return Singleton instance
     */
    public static InitializingOnDemandHolderIdiom getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 获取懒加载的单例实例
     */
    private static class SingletonHolder {
        private static final InitializingOnDemandHolderIdiom INSTANCE = new InitializingOnDemandHolderIdiom();
    }
}
