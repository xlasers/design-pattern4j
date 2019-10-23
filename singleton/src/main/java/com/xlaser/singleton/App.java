package com.xlaser.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 单例模式:每个Java类加载器只有一个可全局访问的实例.
 * <p>
 * 单例问题:分布式环境下单例模式会有同步异步的问题,单例下debug调式又不会重现问题,难以查找.
 * <p>
 * 枚举单例:{@linkplain EnumIvoryTower link}一种特殊的饿汉模式实现单例.
 * <p>
 * 饿汉模式:{@link IvoryTower}线程安全,适用于启动加载时间充足的项目.
 * <p>
 * 懒汉模式: {@link LazySingleton}懒加载模式,初始化为null,调用时加载,存在线程安全问题.
 * <p>
 * 安全懒汉: {@link ThreadSafeLazyLoadedIvoryTower}懒加载模式,按需加载,同时加上锁机制,保证线程安全,访问慢!
 * <p>
 * 安全懒汉内部类: {@link InitializingOnDemandHolderIdiom}利用Java8语言内部类特性,实现线程安全的单例模式
 *
 * @package: com.xlaser.singleton
 * @author: Elijah.D
 * @time: 2018/8/25 18:05
 * @description: 单例模式, Main方法主类
 * @copyright: Copyright© 2018
 * @version: V1.0
 * @modified: Elijah.D
 */
@Slf4j
public class App {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<【singleton 单例模式】>>>>>>>>>>>>>>>>>>>>>>>>>");

        // eagerly initialized singleton
        IvoryTower ivoryTower1 = IvoryTower.getInstance();
        IvoryTower ivoryTower2 = IvoryTower.getInstance();
        log.info("ivoryTower1={}", ivoryTower1);
        log.info("ivoryTower2={}", ivoryTower2);

        // lazily initialized singleton
        ThreadSafeLazyLoadedIvoryTower threadSafeIvoryTower1 = ThreadSafeLazyLoadedIvoryTower.getInstance();
        ThreadSafeLazyLoadedIvoryTower threadSafeIvoryTower2 = ThreadSafeLazyLoadedIvoryTower.getInstance();
        log.info("threadSafeIvoryTower1={}", threadSafeIvoryTower1);
        log.info("threadSafeIvoryTower2={}", threadSafeIvoryTower2);

        // enum singleton
        EnumIvoryTower enumIvoryTower1 = EnumIvoryTower.INSTANCE;
        EnumIvoryTower enumIvoryTower2 = EnumIvoryTower.INSTANCE;
        log.info("enumIvoryTower1={}", enumIvoryTower1);
        log.info("enumIvoryTower2={}", enumIvoryTower2);

        // double checked locking
        ThreadSafeDoubleCheckLocking dcl1 = ThreadSafeDoubleCheckLocking.getInstance();
        log.info(dcl1.toString());
        ThreadSafeDoubleCheckLocking dcl2 = ThreadSafeDoubleCheckLocking.getInstance();
        log.info(dcl2.toString());

        // initialize on demand holder idiom
        InitializingOnDemandHolderIdiom demandHolderIdiom = InitializingOnDemandHolderIdiom.getInstance();
        log.info(demandHolderIdiom.toString());
        InitializingOnDemandHolderIdiom demandHolderIdiom2 =
                InitializingOnDemandHolderIdiom.getInstance();
        log.info(demandHolderIdiom2.toString());
    }
}
