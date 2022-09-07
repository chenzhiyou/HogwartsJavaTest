package com.hogwarts.interfaceTest.ch10_wework_interface.po;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.util.FakerUtil;
import io.restassured.filter.Filter;
import io.restassured.response.Response;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepartApi extends BaseApi{
    // 添加部门
    public Response addDepart(){
        DocumentContext context = null;
        try {
            context = JsonPath.parse(new File("src/test/resources/department3.json"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        context.set("$.name", FakerUtil.get_name()+FakerUtil.get_zh_phone());
        context.set("$.order", FakerUtil.getNum(30));
        String jsonString = context.jsonString();
        System.out.println(jsonString);
        String creatDepartmentUrl = "https://qyapi.weixin.qq.com/cgi-bin/department/create";

        HashMap<String, String> query = new HashMap<String, String>(){{
            put("access_token", "dyyT4_HC22EX1tCib819X72cA6IyO6KtFuQga24UmSOs9xf2jkx2DLQjoEu1CaSU-SoKO5Dd6sftPmyiLOirdrJT3xVR57ESBFm9E6rfCoubm7hFX_5dw_LTXEKWe84RDcxSsNYGf9Omdj3CqIN1UAKjiu6g_q9LKZIEsXe4uP9c5XN8TQm7oi1tXVeZQGROXflxUtLjRO_kMInNoL7Qdw");
        }};
        List<Filter> filters = new ArrayList<Filter>(){{
            add(new ApiFilter());
        }};
        Response response = run(filters,"post",creatDepartmentUrl, "application/json",null, null, jsonString);
        return response;
    }
}
