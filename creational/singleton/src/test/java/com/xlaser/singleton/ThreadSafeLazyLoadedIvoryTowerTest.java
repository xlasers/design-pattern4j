package com.xlaser.singleton;

/**
 * @package: com.xlaser.singleton
 * @author: Elijah.D
 * @time: 2019/10/22 16:02
 * @description: 测试安全懒加载的单例
 * @copyright: Copyright© 2019
 * @version: V1.0
 * @modified: Elijah.D
 */
public class ThreadSafeLazyLoadedIvoryTowerTest extends AbstractSingletonTest<ThreadSafeLazyLoadedIvoryTower> {
    /**
     * 获取ThreadSafeLazyLoadedIvoryTower实例,通过getInstance方法
     */
    public ThreadSafeLazyLoadedIvoryTowerTest() {
        super(ThreadSafeLazyLoadedIvoryTower::getInstance);
    }
}
