package com.hogwarts.junit5Basics.ceshiren;

import com.hogwarts.ceshiren.Calculator;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;

import java.lang.reflect.Method;
import java.util.Optional;

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
public class CalculatorBaseTest {
    static final Logger logger = getLogger(lookup().lookupClass());
    static Calculator calculator;
    public int result;
    public String strResult;

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
    void afterEach(TestInfo testInfo){
        Optional<Method> testMethod = testInfo.getTestMethod();
        String string = testInfo.getTestMethod().map(Method::getName).filter(str -> str.startsWith("str"))
                        .ofNullable(strResult).orElseGet(()->String.valueOf(result));
        logger.info("计算结果为:"+ string);
        calculator.destroyId();
    }

    @AfterAll
    static void afterAll(){
        calculator.close();
    }
}
