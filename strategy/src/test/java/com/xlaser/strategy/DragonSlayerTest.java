package com.xlaser.strategy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * @package: com.xlaser.strategy
 * @author: Elijah.D
 * @time: 2019/11/6 11:38
 * @description: 测试battle方法中使用了strategy, change方法中更换了策略
 * @copyright: Copyright© 2019
 * @version: V1.0
 * @modified: Elijah.D
 */
public class DragonSlayerTest {
    /**
     * 验证{@link DragonSlayer#goToBattle()}battle过程中调用了{@link DragonSlayingStrategy#execute()}
     */
    @Test
    public void testGoToBattle() {
        // MOCK DATA
        DragonSlayingStrategy strategy = Mockito.mock(DragonSlayingStrategy.class);
        DragonSlayer slayer = new DragonSlayer(strategy);

        // CALL BATTLE
        slayer.goToBattle();

        // 验证实际调用了策略方法的execute
        Mockito.verify(strategy).execute();

        // 验证没有产生未verify的交互
        Mockito.verifyNoMoreInteractions(strategy);
    }

    /**
     * 验证{@link DragonSlayer#changeStrategy(DragonSlayingStrategy)}battle过程中调用新的strategy
     */
    @Test
    public void testChangeStrategy() {
        // MOCK FIRST DATA
        DragonSlayingStrategy defaultStrategy = Mockito.mock(DragonSlayingStrategy.class);
        DragonSlayer slayer = new DragonSlayer(defaultStrategy);
        slayer.goToBattle();
        Mockito.verify(defaultStrategy).execute();

        // CHANGE MOCK DATA
        DragonSlayingStrategy newStrategy = Mockito.mock(DragonSlayingStrategy.class);
        slayer = new DragonSlayer(newStrategy);
        slayer.goToBattle();
        Mockito.verify(newStrategy).execute();

        // 验证没有产生未verify的交互
        Mockito.verifyNoMoreInteractions(defaultStrategy, newStrategy);
    }
}
