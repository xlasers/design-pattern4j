package com.xlaser.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * @package: com.xlaser.strategy
 * @author: Elijah.D
 * @time: 2019/10/30 18:04
 * @description: 策略2: 远攻
 * @copyright: Copyright© 2019
 * @version: V1.0
 * @modified: Elijah.D
 */
@Slf4j
public class ProjectileStrategy implements DragonSlayingStrategy {
    /**
     * projectile attack
     */
    @Override
    public void execute() {
        log.info("【ProjectileStrategy】:======> 你用魔法弩射中了巨龙,巨龙到底而亡!");
    }
}
