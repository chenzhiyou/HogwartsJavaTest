package com.hogwarts.interfaceTest.ch10_wework_interface.potest;

import com.hogwarts.interfaceTest.ch10_wework_interface.po.DepartApi;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;

import java.util.List;
import java.util.stream.Stream;

import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.given;
import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.slf4j.LoggerFactory.getLogger;

public class DepartTest extends BaseTest{

    @Test
    public void addDepartTest() {
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

    @Test
    public void getDepartTest(){
        Response getDepartRes = departApi.getDepart();
        Integer errCode2 = getDepartRes.path("errcode");
        String errMsg2 = getDepartRes.path("errmsg");

        assertAll(
                () -> assertEquals(0, errCode2),
                () -> assertEquals("ok", errMsg2)
        );
    }

    @ParameterizedTest
    @MethodSource("deleteParamsDepartment")
    public void deleteDepartTest(Integer departmentId){
        Response deleteDepart = departApi.deleteDepart(departmentId);

    }

    static Stream<Arguments> deleteParamsDepartment(){
        Response getDepartRes = departApi.getDepart();
        // 获取order<100的部门ID列表
        List<Arguments> orderId = getDepartRes.path("department_id.findAll{ it.order <1000}.id");
        System.out.println(orderId);
        if (orderId.isEmpty()){
            return Stream.of(Arguments.arguments(-1));
        }else {
            return orderId.stream();
        }
    }



}
