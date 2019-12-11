package com.xlaser.singleton;

/**
 * @package: com.xlaser.singleton
 * @author: Elijah.D
 * @time: 2019/9/27 20:59
 * @description: 枚举天然实现枚举, 线程安全
 * @copyright: Copyright© 2019
 * @version: V1.0
 * @modified: Elijah.D
 */
public enum EnumIvoryTower {
    /**
     * 实例
     */
    INSTANCE;

    @Override
    public String toString() {
        return getDeclaringClass().getCanonicalName() + "@" + hashCode();
    }
}
