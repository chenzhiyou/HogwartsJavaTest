package com.hogwarts.learn.ch24_calculator;

import learn.ch36_calculator.Calculator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class BaseTest {
    public static Calculator calculator;
    static final Logger logger = getLogger(lookup().lookupClass());
    public int sum;
    public String message;

    /**
     * @BeforeAll 注解 static修饰 void返回值 与在代码中的前后顺序无关
     * 在测试类里面运行一次，并且是在所有的方法运行之前运行一次
     * 作用：对象的声明 测试数据准备 log日志删除 apk安装 启动的某些参数的配置 AppiumDriver webDriver ChromeDriver
     */
    @BeforeAll
    public static void beforeAll(){
        calculator = new Calculator("计算器");
        calculator.initId();
    }

    /**
     * @AfterAll注解，static修饰，void返回值
     * 在测试类里面运行一次，并且是在所有的方法之后运行一次
     * 作用：apk卸载，APP退出，测试用例结束，WEB端关闭浏览器操作
     */
    @AfterAll
    public static void afterAll(){
        calculator.close();
    }

    /**
     * void返回值
     * @BeforeEach注解 在每一个@Test注解修饰的方法之前运行一次 所以，当前测试类有多少个Test注解，BeforeEach注解修饰的方法就会运行多少次
     * 作用：测试用例中，测试方法需要初始化的内容及属性 [APP/WEB进入固定页面，回退到固定页面；重启APP；删除某些产生的测试数据]
     */
    @BeforeEach
    public void beforeEach(){
        logger.info("开始进行加法计算");
    }

    // 无论@Test注解修饰的测试方法是否断言成功，@AfterEach方法内容都去执行
    @AfterEach
    public void after(){
        logger.info("计算结果为{}"+ sum);
    }
}
