package com.xlaser.singleton;

/**
 * @package: com.xlaser.singleton
 * @author: Elijah.D
 * @time: 2019/10/22 14:41
 * @description: 测试恶汉模式实现的单例
 * @copyright: Copyright© 2019
 * @version: V1.0
 * @modified: Elijah.D
 */
public class IvoryTowerTest extends AbstractSingletonTest<IvoryTower> {
    /**
     * 获取IvoryTower实例,通过getInstance方法
     */
    public IvoryTowerTest() {
        super(IvoryTower::getInstance);
    }
}