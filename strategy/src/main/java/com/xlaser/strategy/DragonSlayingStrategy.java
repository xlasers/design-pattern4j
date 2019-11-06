package com.xlaser.strategy;

/**
 * @package: com.xlaser.strategy
 * @author: Elijah.D
 * @time: 2019/10/30 18:03
 * @description: 屠龙策略接口
 * @copyright: Copyright© 2019
 * @version: V1.0
 * @modified: Elijah.D
 */
@FunctionalInterface
public interface DragonSlayingStrategy {
    /**
     * 策略接口
     */
    void execute();
}
