package com.xlaser.singleton;

/**
 * @package: com.xlaser.singleton
 * @author: Elijah.D
 * @time: 2019 /9/28 11:37
 * @description: 懒汉模式, 线程安全问题
 * @copyright: Copyright © 2019
 * @version: V1.0
 * @modified: Elijah.D
 */
public class LazySingleton {
    private static LazySingleton s;

    private LazySingleton() {

    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static LazySingleton getInstance() {
        if (s == null) {
            // 此处会发生线程安全问题
            s = new LazySingleton();
        }
        return s;
    }
}
