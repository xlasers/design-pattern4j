package com.xlaser.singleton;

import java.lang.reflect.Constructor;

import cn.hutool.core.exceptions.UtilException;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.ReflectUtil;
import org.junit.Test;

/**
 * 1.测试获取单例之后,反射抛出异常
 * <p>
 * 2.测试反射获取单例之后,正常抛出异常
 * <p>
 * 3.每次运行一种
 *
 * @package: com.xlaser.singleton
 * @author: Elijah.D
 * @time: 2019/10/22 15:44
 * @description: 测试反射单例
 * @copyright: Copyright© 2019
 * @version: V1.0
 * @modified: Elijah.D
 */
public class ReflectTest {
    /**
     * 测试反射创建实例: new ==>> reflect
     */
    @Test(expected = UtilException.class)
    public void testCreateNewInstanceByNew() {

        // 首次加载单例
        ThreadSafeDoubleCheckLocking instanceByNew = ThreadSafeDoubleCheckLocking.getInstance();
        Console.log("【instanceByNew】:{}", instanceByNew);

        // 反射获取异常
        ThreadSafeDoubleCheckLocking instanceByReflect = ReflectUtil.newInstance(ThreadSafeDoubleCheckLocking.class);
        Console.log("【instanceByReflect】:{}", instanceByReflect);
    }

    /**
     * 测试反射创建实例: reflect ==>> new
     */
    @Test(expected = IllegalStateException.class)
    public void testCreateNewInstanceByReflect() throws Exception {

        // 首次,修改构造可访问,通过反射获取
        Constructor constructor = ThreadSafeDoubleCheckLocking.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        ThreadSafeDoubleCheckLocking instanceByReflect = (ThreadSafeDoubleCheckLocking)constructor.newInstance();
        Console.log("【instanceByReflect】:{}", instanceByReflect);

        // 再次加载单例异常
        ThreadSafeDoubleCheckLocking instanceByNew = ThreadSafeDoubleCheckLocking.getInstance();
        Console.log("【instanceByNew】:{}", instanceByNew);
    }
}
