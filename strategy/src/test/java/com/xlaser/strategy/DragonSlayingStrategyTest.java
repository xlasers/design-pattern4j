package com.xlaser.strategy;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.LoggerFactory;

/**
 * @package: com.xlaser.strategy
 * @author: Elijah.D
 * @time: 2019/11/6 11:39
 * @description: 测试不同策略
 * @copyright: Copyright© 2019
 * @version: V1.0
 * @modified: Elijah.D
 */
public class DragonSlayingStrategyTest {
    private InMemoryAppender appender;

    /**
     * 参数化测试数据源{@link org.junit.jupiter.params.provider.MethodSource};
     * 返回可迭代的数据,比如集合Collection,流Stream.
     * <p>
     * 其中单个参数可以使用相应类型如:{@code Stream<String>},或者原始流{@link java.util.stream.IntStream}.
     * 多个参数需要封装如下{@code Stream<Arguments>},或者使用集合{@code Collection<Object[]>}根据测试方法
     * 手动创建参数个数类型.
     *
     * @return
     */
    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(new MeleeStrategy(), "【MeleeStrategy】:======> 混战中你用亚瑟王神剑斩断了巨龙的脑袋!"),
                Arguments.of(new ProjectileStrategy(), "【ProjectileStrategy】:======> 你用魔法弩射中了巨龙,巨龙到底而亡!"),
                Arguments.of(new SpellStrategy(), "【SpellStrategy】:======> 你释放了瓦解一切咒语,巨龙在怒吼中化成一堆灰烬!")
        );
    }

    /**
     * 等价于junit4中的{@code Before}每次都会执行.
     * <p>
     * 而{@link org.junit.jupiter.api.BeforeAll}等价于junit4中的{@code BeforeClass}整个测试类执行一次,如
     * 十个测试用例类中,Before/BeforeEach会执行10次,但BeforeAll/BeforeClass只会执行一次,并且作为静态初始化
     * 执行,在创建测试类之前执行.
     */
    @BeforeEach
    public void setUp() {
        appender = new InMemoryAppender();
    }

    /**
     * 同上:
     * {@code After} ====> {@link org.junit.jupiter.api.AfterEach}
     * <p>
     * {@code AfterClass} ====> {@link org.junit.jupiter.api.AfterAll}
     */
    @AfterEach
    public void tearDown() {
        appender.stop();
    }

    /**
     * 测试不同执行策略是否返回正确的msg
     * <p>
     * 参数化测试场景:{@code ParameterizedTest}有一个方法根据不同的参数会有不同的结果,为了测试全面如果把所有
     * 可能的情况都逐个写出来测试一遍代码重复性高,不够优雅,此时就可以用参数化测试,创建不同场景以及结果的数据源
     * 如:{@code dataProvider},而后执行参数化测试即可.
     * <p>
     * 数据源依赖于:{@link MethodSource}通常是内部或者外部类的一个静态工厂类,测试方法根据数据源名称匹配,如果
     * 不注明方法名,则默认按照测试方法查找(例如:这里的source不写参数dataProvider,当执行testExecute时会自动搜索
     * 方法名叫{@code testExecute}的数据源),最好按照规范书写,减少故障.
     *
     * @param strategy
     * @param expectedResult
     */
    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testExecute(DragonSlayingStrategy strategy, String expectedResult) {
        strategy.execute();
        Assertions.assertEquals(expectedResult, appender.getLastMessage());
        Assertions.assertEquals(1, appender.getLogSize());
    }

    /**
     * 创建日志记录器,后续测试检查输出日志信息
     */
    private static class InMemoryAppender extends AppenderBase<ILoggingEvent> {
        private List<ILoggingEvent> log = new LinkedList<>();

        InMemoryAppender() {
            ((Logger)LoggerFactory.getLogger("root")).addAppender(this);
            start();
        }

        @Override
        protected void append(ILoggingEvent eventObject) {
            log.add(eventObject);
        }

        /**
         * 获取数量
         *
         * @return count
         */
        public int getLogSize() {
            return log.size();
        }

        /**
         * format日志信息
         *
         * @return msg
         */
        public String getLastMessage() {
            return log.get(log.size() - 1).getFormattedMessage();
        }
    }
}
