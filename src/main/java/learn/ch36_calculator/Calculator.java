package learn.ch36_calculator;

import org.slf4j.Logger;

import java.util.Arrays;
import java.util.UUID;
import java.util.stream.IntStream;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class Calculator {
    /**
     * 获得具有所需名称的记录器
     */
    static final Logger logger = getLogger(lookup().lookupClass());

    public static int result = 0;

    //用例名
    String name;
    //唯一ID标识
    String id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Calculator(String name) {
        this.name = name;
        logger.info("创建 {} ", name);
    }

    public void initId(){
        id = UUID.randomUUID().toString();
        logger.info("生成ID：{} 并绑定", id);

    }
    public void destroyId() {
        if (id == null) {
            throw new IllegalArgumentException(name + " 没有初始化对应ID");
        }
        logger.info("ID: {} 释放", id);
        id = null;
    }


    public void close() {
        logger.info("关闭 {} ", name);
    }


    //连续添加
    public int sum(int... numbers) {
        if(Arrays.stream(numbers).anyMatch(u -> u == 100)){
            logger.warn("integer is 100！");
            //拦截，重置，发送某些消息给其他服务端
            throw new NumberFormatException("integer is 100！");
        }else if(Arrays.stream(numbers).anyMatch(u -> u > 99) | Arrays.stream(numbers).anyMatch(u -> u < -99)){
            logger.warn("请输入范围内的整数");
            throw new IllegalArgumentException("请输入范围内的整数！");
//            throw new NumberFormatException("请输入范围内的整数！");

        }else {
            //[-99,99]
            return IntStream.of(numbers).sum();
        }

    }
}
