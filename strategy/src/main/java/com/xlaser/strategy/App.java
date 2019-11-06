package com.xlaser.strategy;

import lombok.extern.slf4j.Slf4j;

/**
 * 软件设计模式中,策略模式是在运行时选择某种算法的行为
 * <p>
 * java8之前没有函数式接口,要实现策略模式,需要不同的类实现策略,导致大量样板重复代码,使用lambda可以便捷实现.
 * <p>
 * 案例中({@link DragonSlayingStrategy}) 屠龙策略. The containing object
 * ({@link DragonSlayer}) can alter its behavior by changing its strategy.
 *
 * @package: com.xlaser.strategy
 * @author: Elijah.D
 * @time: 2019/10/30 17:10
 * @description: 策略模式
 * @copyright: Copyright© 2019
 * @version: V1.0
 * @modified: Elijah.D
 */
@Slf4j
public class App {
    public static void main(String[] args) {

        log.info("\n==================================================传统策略模式,产生三种样板代码====================================================");
        log.info("【GREEN-DRAGON】:~~绿龙飞来~~");
        DragonSlayer slayer = new DragonSlayer(new MeleeStrategy());
        slayer.goToBattle();

        log.info("【RED-DRAGON】:~~赤龙闪现~~");
        slayer.changeStrategy(new ProjectileStrategy());
        slayer.goToBattle();

        log.info("【BLACK-DRAGON】:~~黑龙降落~~");
        slayer.changeStrategy(new SpellStrategy());
        slayer.goToBattle();
        log.info("\n==================================================传统策略模式,产生三种样板代码====================================================\n\n");

        log.info("\n==================================================利用lambda实现,去除样板代码=======================================================");
        log.info("【GREEN-DRAGON】:~~绿龙飞来~~");
        slayer = new DragonSlayer(() -> log.info("【MeleeStrategy】:======> 混战中你用亚瑟王神剑斩断了巨龙的脑袋!"));
        slayer.goToBattle();

        log.info("【RED-DRAGON】:~~赤龙闪现~~");
        slayer.changeStrategy(() -> log.info("【ProjectileStrategy】:======> 你用魔法弩射中了巨龙,巨龙到底而亡!"));
        slayer.goToBattle();

        log.info("【BLACK-DRAGON】:~~黑龙降落~~");
        slayer.changeStrategy(() -> log.info("【SpellStrategy】:======> 你释放了瓦解一切咒语,巨龙在怒吼中化成一堆灰烬!"));
        slayer.goToBattle();
        log.info("\n==================================================利用lambda实现,去除样板代码=======================================================");
    }
}
