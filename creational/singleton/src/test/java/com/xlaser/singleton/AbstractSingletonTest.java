package com.xlaser.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 1.测试场景: 单线程下多次调用
 * <p>
 * 2.测试场景: 多线程下多次调用
 *
 * @package: com.xlaser.singleton
 * @author: Elijah.D
 * @time: 2019/10/22 14:41
 * @description: 抽象测试父类, 统一设计两种测试场景
 * @copyright: Copyright© 2019
 * @version: V1.0
 * @modified: Elijah.D
 */
public abstract class AbstractSingletonTest<T> {
    /**
     * common 获取单例方法
     */
    private final Supplier<T> getInstance;

    /**
     * 创建测试单例的方法,利用不同的单例getInstance
     *
     * @param getInstance 参数获取单例的方法
     */
    public AbstractSingletonTest(Supplier<T> getInstance) {
        this.getInstance = getInstance;
    }

    /**
     * SAME THREAD
     * <p>
     * 测试:单线程下调用单例获取对象相同
     */
    @Test
    public void testMultipleCallsReturnTheSameObjectInSameThread() {
        // 获取多个实例
        T instance1 = getInstance.get();
        T instance2 = getInstance.get();
        T instance3 = getInstance.get();

        // 检查相同
        assertSame(instance1, instance2);
        assertSame(instance1, instance3);
        assertSame(instance2, instance3);
    }

    /**
     * DIFFERENT THREAD
     * <p>
     * 测试:多线程下调用单例获取对象相同
     */
    @Test
    public void testMultipleCallsReturnTheSameObjectInDifferentThreads() {
        assertTimeout(ofMillis(10000), () -> {
            // 创建1k个任务分别获取单例
            List<Callable<T>> tasks = new ArrayList<>();
            for (int i = 0; i < 10000; i++) {
                tasks.add(getInstance::get);
            }
            // 创建8个并发线程处理
            ExecutorService executorService = Executors.newFixedThreadPool(8);
            List<Future<T>> results = executorService.invokeAll(tasks);

            // 检查结果
            T expectedInstance = getInstance.get();
            for (Future<T> res : results) {
                T instance = res.get();
                assertNotNull(instance);
                assertSame(expectedInstance, instance);
            }
            // 关闭线程池
            executorService.shutdown();
        });
    }
}
