package com.hogwarts.interfaceTest.ch10_wework_interface.potest;

import com.hogwarts.interfaceTest.ch10_wework_interface.po.DepartApi;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.slf4j.LoggerFactory.getLogger;

public class DepartTest extends BaseTest{

    @Test
    public void addDepartTest(){
        logger.info("添加部门的测试用例");
        Response response = departApi.addDepart();
        Integer errCode = response.path("errcode");
        String errMsg = response.path("errmsg");

        // 多断言
        assertAll(
                () -> assertEquals(0, errCode),
                () -> assertEquals("created", errMsg)
        );

    }
}
