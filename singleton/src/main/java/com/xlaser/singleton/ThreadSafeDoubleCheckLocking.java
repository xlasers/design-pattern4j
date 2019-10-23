package com.xlaser.singleton;

/**
 * @package: com.xlaser.singleton
 * @author: Elijah.D
 * @time: 2019/9/27 21:03
 * @description: 双重检查锁的单例
 * @copyright: Copyright© 2019
 * @version: V1.0
 * @modified: Elijah.D
 */
public final class ThreadSafeDoubleCheckLocking {
    private static volatile ThreadSafeDoubleCheckLocking instance;

    private static boolean flag = true;

    /**
     * 私有构造，防止实例化对象,flag防止反射获取
     */
    private ThreadSafeDoubleCheckLocking() {
        // 防止反射调用私有构造获取对象，flag保证只能调用一次构造
        if (flag) {
            flag = false;
        } else {
            throw new IllegalStateException("对象已经实例化!");
        }
    }

    /**
     * 获取实例
     *
     * @return 单例对象
     */
    public static ThreadSafeDoubleCheckLocking getInstance() {
        // 局部变量提高访问性能
        ThreadSafeDoubleCheckLocking result = instance;

        // 如果已经实例化则直接返回对象
        if (result == null) {
            // 多线程下防止其他线程实例化，加锁确保只有当前线程持有类
            synchronized (ThreadSafeDoubleCheckLocking.class) {
                // 再次赋值给局部变量，防止在首次检查之后加锁之前的时间段被其他线程实例化，直接返回实例化的对象
                result = instance;
                if (result == null) {
                    // 单例未实例化，加锁确保其他线程阻塞，在此获取单例对象
                    instance = result = new ThreadSafeDoubleCheckLocking();
                }
            }
        }
        return result;
    }
}
