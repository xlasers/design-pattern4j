package com.xlaser.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * @package: com.xlaser.strategy
 * @author: Elijah.D
 * @time: 2019/10/30 18:04
 * @description: 策略2: 咒语
 * @copyright: Copyright© 2019
 * @version: V1.0
 * @modified: Elijah.D
 */
@Slf4j
public class SpellStrategy implements DragonSlayingStrategy {
    /**
     * spell attack
     */
    @Override
    public void execute() {
        log.info("【SpellStrategy】:======> 你释放了瓦解一切咒语,巨龙在怒吼中化成一堆灰烬!");
    }
}
