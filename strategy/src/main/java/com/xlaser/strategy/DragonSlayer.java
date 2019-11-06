package com.xlaser.strategy;

import lombok.AllArgsConstructor;

/**
 * @package: com.xlaser.strategy
 * @author: Elijah.D
 * @time: 2019/10/30 18:05
 * @description: 屠龙者, 拥有不同的策略
 * @copyright: Copyright© 2019
 * @version: V1.0
 * @modified: Elijah.D
 */
@AllArgsConstructor
public class DragonSlayer {
    private DragonSlayingStrategy strategy;

    /**
     * change strategy and to battle
     *
     * @param strategy 策略
     */
    public void changeStrategy(DragonSlayingStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * attack
     */
    public void goToBattle() {
        strategy.execute();
    }
}
