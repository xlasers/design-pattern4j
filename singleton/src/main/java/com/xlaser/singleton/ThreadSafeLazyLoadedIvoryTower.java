package com.xlaser.singleton;

/**
 * 利用synchronized关键字保证线程安全,null判断保证反射单例
 *
 * @package: com.xlaser.singleton
 * @author: Elijah.D
 * @time: 2019/9/27 21:37
 * @description: 懒汉模式, 线程安全
 * @copyright: Copyright © 2019
 * @version: V1.0
 * @modified: Elijah.D
 */
public final class ThreadSafeLazyLoadedIvoryTower {
    private static ThreadSafeLazyLoadedIvoryTower instance;

    /**
     * 私有构造防止反射实例化对象
     */
    private ThreadSafeLazyLoadedIvoryTower() {
        // 防止通过反射实例化,如果不加判断,则反射会获取不同的实例
        if (instance == null) {
            instance = this;
        } else {
            throw new IllegalStateException("Already initialized.");
        }
    }

    /**
     * 仅仅首次调用,保证单例
     *
     * @return the instance
     */
    public static synchronized ThreadSafeLazyLoadedIvoryTower getInstance() {
        if (instance == null) {
            instance = new ThreadSafeLazyLoadedIvoryTower();
        }

        return instance;
    }
}
