package com.xlaser.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * @package: com.xlaser.strategy
 * @author: Elijah.D
 * @time: 2019/10/30 18:03
 * @description: 策略1: 混战
 * @copyright: Copyright© 2019
 * @version: V1.0
 * @modified: Elijah.D
 */
@Slf4j
public class MeleeStrategy implements DragonSlayingStrategy {
    /**
     * melee attack
     */
    @Override
    public void execute() {
        log.info("【MeleeStrategy】:======> 混战中你用亚瑟王神剑斩断了巨龙的脑袋!");
    }
}
