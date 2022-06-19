package com.hogwarts.junit5Basics.ceshiren;

import com.hogwarts.ceshiren.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.slf4j.LoggerFactory.getLogger;

public class CalculatorTest {
    static final Logger logger = getLogger(lookup().lookupClass());
    Calculator calculator = new Calculator("计算器");

    @Test
    @DisplayName("整数相加")
    void Ca_add_001(){
        calculator.initId();
        logger.info("开始计算");
        int result = calculator.sum(1, 1);
        logger.info("计算结果为："+ result);
        assertEquals(2, result);

    }

    @Test
    @DisplayName("三个整数相加")
    void Ca_add_002(){
        calculator.initId();
        logger.info("开始计算");
        int result = calculator.sum(1, 1, 9);
        logger.info("计算结果为："+ result);
        assertEquals(11, result);
    }

    @Test
    @DisplayName("有效边界值相加，99+99")
    void Ca_add_003(){
        calculator.initId();
        logger.info("开始计算");
        int result = calculator.sum(99, 99);
        logger.info("计算结果为："+ result);
        assertEquals(198, result);
    }

    @Test
    @DisplayName("有效边界值相加，-99+99")
    void Ca_add_004(){
        calculator.initId();
        logger.info("开始计算");
        int result = calculator.sum(-99, 99);
        logger.info("计算结果为："+ result);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("有效边界值相加，-99+(-99)")
    void Ca_add_005(){
        calculator.initId();
        logger.info("开始计算");
        int result = calculator.sum(-99, -99);
        logger.info("计算结果为："+ result);
        assertEquals(-198, result);
    }

    @Test
    @DisplayName("无效边界值相加，100+0")
    void Ca_add_006(){
        calculator.initId();
        logger.info("开始计算");
//        int result = calculator.sum(100, 0);
        assertThrows(IllegalArgumentException.class, ()->calculator.subtract(100,0));
    }

    @Test
    @DisplayName("无效边界值相加，-100+(-1)")
    void Ca_add_007(){
        calculator.initId();
        logger.info("开始计算");
        int result = calculator.sum(-100, -0);
    }

    @Test
    @DisplayName("无效边界值相加，2+100")
    void Ca_add_008(){
        calculator.initId();
        logger.info("开始计算");
        int result = calculator.sum(100, 2);
    }

    @Test
    @DisplayName("无效边界值相加，1+(-100)")
    void Ca_add_009(){
        calculator.initId();
        logger.info("开始计算");
        int result = calculator.sum(1, -100);
    }

    @Test
    @DisplayName("2个整数相减")
    void Ca_add_010(){
        calculator.initId();
        logger.info("开始计算");
        int result = calculator.subtract(10, 10);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("有效边界值相减 99-99")
    void Ca_add_011(){
        calculator.initId();
        logger.info("开始计算");
        int result = calculator.subtract(99, 99);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("有效边界值相减 -99-99")
    void Ca_add_012(){
        calculator.initId();
        logger.info("开始计算");
        int result = calculator.subtract(-99, 99);
        assertEquals(-198, result);
    }

    @Test
    @DisplayName("有效边界值相减 99-(-99)")
    void Ca_add_013(){
        calculator.initId();
        logger.info("开始计算");
        int result = calculator.subtract(99, -99);
        assertEquals(198, result);
    }

    @Test
    @DisplayName("有效边界值相减 -99-(-99)")
    void Ca_add_014(){
        calculator.initId();
        logger.info("开始计算");
        int result = calculator.subtract(-99, -99);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("无效边界值 100-0")
    void Ca_add_015(){
        calculator.initId();
        logger.info("开始计算");
        int result = calculator.subtract(100, 0);
    }

    @Test
    @DisplayName("无效边界值 -100-(-1)")
    void Ca_add_016(){
        calculator.initId();
        logger.info("开始计算");
        int result = calculator.subtract(-100, -1);
    }

    @Test
    @DisplayName("无效边界值 2-100")
    void Ca_add_017(){
        calculator.initId();
        logger.info("开始计算");
        int result = calculator.subtract(2, 100);
    }

    @Test
    @DisplayName("无效边界值 1-(-100)")
    void Ca_add_018(){
        calculator.initId();
        logger.info("开始计算");
        int result = calculator.subtract(1, -100);
    }

    @Test
    @DisplayName("字符串拼接")
    void Ca_add_019(){
        calculator.initId();
        logger.info("开始计算");
        String result = calculator.concatStr("Hello", "Junit5");
        assertEquals("Hello Junit5", result);
    }

    @Test
    @DisplayName("字符串拼接")
    void Ca_add_020(){
        calculator.initId();
        logger.info("开始计算");
        String result = calculator.concatStr("你好", "世界");
        assertEquals("你好 世界", result);
    }

    @Test
    @DisplayName("字符串拼接")
    void Ca_add_021(){
        calculator.initId();
        logger.info("开始计算");
        String result = calculator.concatStr("这里", "是", "北京");
        assertEquals("这里 是 北京", result);
    }

}
