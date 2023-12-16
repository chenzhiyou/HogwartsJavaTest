package learn.ch34_log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jDemo {
    public static void main(String[] args) {
        //创建日志实例
        Logger logger = LoggerFactory.getLogger(Slf4jDemo.class);
        logger.error("hogwarts:error");
        logger.warn("hogwarts:warn");
        logger.info("hogwarts:info");
        logger.debug("hogwarts:debug");
        logger.trace("hogwarts:trace");
    }
}
