package com.xlaser.singleton;

/**
 * @package: com.xlaser.singleton
 * @author: Elijah.D
 * @time: 2019/10/22 14:41
 * @description: 测试枚举单例
 * @copyright: Copyright© 2019
 * @version: V1.0
 * @modified: Elijah.D
 */
public class EnumIvoryTowerTest extends AbstractSingletonTest<EnumIvoryTower> {
    /**
     * 获取EnumIvoryTower实例,通过getInstance方法
     */
    public EnumIvoryTowerTest() {
        super(() -> EnumIvoryTower.INSTANCE);
    }
}
