package com.xlaser.singleton;

/**
 * @package: com.xlaser.singleton
 * @author: Elijah.D
 * @time: 2019/10/22 14:41
 * @description: 测试通过内部类实现的安全懒汉单例
 * @copyright: Copyright© 2019
 * @version: V1.0
 * @modified: Elijah.D
 */
public class InitializingOnDemandHolderIdiomTest extends AbstractSingletonTest<InitializingOnDemandHolderIdiom> {
    /**
     * 获取InitializingOnDemandHolderIdiom实例,通过getInstance方法
     */
    public InitializingOnDemandHolderIdiomTest() {
        super(InitializingOnDemandHolderIdiom::getInstance);
    }
}