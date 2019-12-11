package com.xlaser.singleton;

/**
 * @package: com.xlaser.singleton
 * @author: Elijah.D
 * @time: 2019/9/27 20:56
 * @description: 饿汉模式的单例实现，线程安全
 * @copyright: Copyright© 2019
 * @version: V1.0
 * @modified: Elijah.D
 */
public final class IvoryTower {
    /**
     * 静态实例
     */
    private static final IvoryTower INSTANCE = new IvoryTower();

    /**
     * 私有构造，无法实例化对象
     */
    private IvoryTower() {
    }

    /**
     * 获取全局静态实例
     */
    public static IvoryTower getInstance() {
        return INSTANCE;
    }
}
