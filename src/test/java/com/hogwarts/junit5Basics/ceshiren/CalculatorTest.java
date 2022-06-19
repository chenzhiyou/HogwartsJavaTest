package com.hogwarts.junit5Basics.ceshiren;

import com.hogwarts.ceshiren.Calculator;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * 1、创建新型计算器对象
 * 2、生成测试用例的ID
 * 3、log日志的打印：开始进行测试计算、
 * 4、业务逻辑编写得出Result
 * 5、log日志打印：计算结果：Result
 * 6、断言计算结果是否正确
 * 7、销毁ID
 * 8、对象close关闭
 *
 * @Test 注解对应方法无论是否执行成功，@AfterEach注解都会执行
 * @AfterEach的作用：
 *  测试用例中，销毁测试方法需要的属性，APP/web自动化测试的时候返回首页，返回固定页面；
 *  log文件删除；
 *  删除业务测试数据
 */
public class CalculatorTest {
    static final Logger logger = getLogger(lookup().lookupClass());
    static Calculator calculator;

    @BeforeAll
    static void beforeAll(){
        calculator = new Calculator("新型计算器");
    }

    @BeforeEach
    void beforeEach(){
        calculator.initId();
        logger.info("开始计算");
    }

    @AfterEach
    void afterEach(){
        calculator.destroyId();
    }

    @AfterAll
    static void afterAll(){
        calculator.close();
    }

    @Test
    @DisplayName("整数相加")
    void Ca_add_001(){
        int result = calculator.sum(1, 1);
        logger.info("计算结果为："+ result);
        assertEquals(2, result);
    }

    @Test
    @DisplayName("三个整数相加")
    void Ca_add_002(){

        int result = calculator.sum(1, 1, 9);
        logger.info("计算结果为："+ result);
        assertEquals(11, result);
    }

    @Test
    @DisplayName("有效边界值相加，99+99")
    void Ca_add_003(){
        int result = calculator.sum(99, 99);
        logger.info("计算结果为："+ result);
        assertEquals(198, result);
    }

    @Test
    @DisplayName("有效边界值相加，-99+99")
    void Ca_add_004(){
        int result = calculator.sum(-99, 99);
        logger.info("计算结果为："+ result);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("有效边界值相加，-99+(-99)")
    void Ca_add_005(){
        int result = calculator.sum(-99, -99);
        logger.info("计算结果为："+ result);
        assertEquals(-198, result);
    }

    @Test
    @DisplayName("无效边界值相加，100+0")
    void Ca_add_006(){
//        int result = calculator.sum(100, 0);
        // 对异常结果的断言
        Exception exception = assertThrows(IllegalArgumentException.class, ()->calculator.sum(100,0));
        String message = exception.getMessage().toString();
        assertThat("失败断言", message, is(containsString("integer is 100")));
    }

    @Test
    @DisplayName("无效边界值相加，-100+(-1)")
    void Ca_add_007(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->calculator.sum(-100, 0));
        String message = exception.getMessage().toString();
        assertThat("失败断言", message, is(containsString("请输入范围内的整数！")));
    }

    @Test
    @DisplayName("无效边界值相加，2+100")
    void Ca_add_008(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->calculator.sum(100,2));
        String message = exception.getMessage().toString();
        assertThat("失败断言",message, is(containsString("integer is 100！")));
    }

    @Test
    @DisplayName("无效边界值相加，1+(-100)")
    void Ca_add_009(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->calculator.sum(1,-100));
        String message = exception.getMessage().toString();
        assertThat("失败断言",message, is(containsString("请输入范围内的整数！")));



    }

    @Test
    @DisplayName("2个整数相减")
    void Ca_add_010(){
        int result = calculator.subtract(10, 10);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("有效边界值相减 99-99")
    void Ca_add_011(){
        int result = calculator.subtract(99, 99);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("有效边界值相减 -99-99")
    void Ca_add_012(){
        int result = calculator.subtract(-99, 99);
        assertEquals(-198, result);
    }

    @Test
    @DisplayName("有效边界值相减 99-(-99)")
    void Ca_add_013(){
        int result = calculator.subtract(99, -99);
        assertEquals(198, result);
    }

    @Test
    @DisplayName("有效边界值相减 -99-(-99)")
    void Ca_add_014(){
        int result = calculator.subtract(-99, -99);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("无效边界值 100-0")
    void Ca_add_015(){
        int result = calculator.subtract(100, 0);
    }

    @Test
    @DisplayName("无效边界值 -100-(-1)")
    void Ca_add_016(){
        int result = calculator.subtract(-100, -1);
    }

    @Test
    @DisplayName("无效边界值 2-100")
    void Ca_add_017(){
        int result = calculator.subtract(2, 100);
    }

    @Test
    @DisplayName("无效边界值 1-(-100)")
    void Ca_add_018(){
        int result = calculator.subtract(1, -100);
    }

    @Test
    @DisplayName("字符串拼接")
    void Ca_add_019(){
        String result = calculator.concatStr("Hello", "Junit5");
        assertEquals("Hello Junit5", result);
    }

    @Test
    @DisplayName("字符串拼接")
    void Ca_add_020(){
        String result = calculator.concatStr("你好", "世界");
        assertEquals("你好 世界", result);
    }

    @Test
    @DisplayName("字符串拼接")
    void Ca_add_021(){
        String result = calculator.concatStr("这里", "是", "北京");
        assertEquals("这里 是 北京", result);
    }
}
