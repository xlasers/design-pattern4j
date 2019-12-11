package com.xlaser.strategy;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * @package: com.xlaser.strategy
 * @author: Elijah.D
 * @time: 2019/11/6 16:03
 * @description: 测试mockito
 * @copyright: Copyright© 2019
 * @version: V1.0
 * @modified: Elijah.D
 */
@SuppressWarnings("unchecked")
public class MockDemoTest {
    /**
     * 简单测试mockito
     */
    @Test
    public void mockTest() {
        List<Integer> success = mock(List.class);
        success.add(1);
        success.add(2);
        verify(success, times(2)).add(anyInt());

        // 检查是否有未被验证的互动行为，因为add(1)和add(2)都会被上面的anyInt()验证到，所以下面的代码会通过
        verifyNoMoreInteractions(success);

        List<Integer> fail = mock(List.class);
        fail.add(1);
        fail.add(2);
        verify(fail).add(1);

        // 检查是否有未被验证的互动行为，因为add(2)没有被验证，所以下面的代码会失败抛出异常
        verifyNoMoreInteractions(fail);
    }
}
