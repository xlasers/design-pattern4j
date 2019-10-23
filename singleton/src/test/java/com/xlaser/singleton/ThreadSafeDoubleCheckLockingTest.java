package com.xlaser.singleton;

/**
 * @package: com.xlaser.singleton
 * @author: Elijah.D
 * @time: 2019/10/22 14:41
 * @description: 测试双重检查锁实现的单例
 * @copyright: Copyright© 2019
 * @version: V1.0
 * @modified: Elijah.D
 */
public class ThreadSafeDoubleCheckLockingTest extends AbstractSingletonTest<ThreadSafeDoubleCheckLocking> {
    /**
     * 获取ThreadSafeDoubleCheckLocking实例,通过getInstance方法
     */
    public ThreadSafeDoubleCheckLockingTest() {
        super(ThreadSafeDoubleCheckLocking::getInstance);
    }
}