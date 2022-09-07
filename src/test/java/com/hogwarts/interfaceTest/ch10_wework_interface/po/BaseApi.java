package com.hogwarts.interfaceTest.ch10_wework_interface.po;


import io.restassured.filter.Filter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class BaseApi {
    public static final Logger logger = getLogger(lookup().lookupClass());

    /**
     * method: 请求方法： Get、Post
     * URL： 请求的地址URL
     * Query： 请求的queryParam
     * ContentType： 请求的编码格式
     * Headers：请求头相关的信息
     * body：post请求的参数body
     * @return
     */
    public Response run(List<Filter> filterList, String method, String url, String contentType,
                        HashMap<String, String> headers,
                        HashMap<String, String> query, String body){
        /**
         * 所有的请求都需要拦截相关的filter，那可以写到baseAPI中
         * 部分请求需要登录，部分请求不需要，建议写到各个接口上
         */
        RequestSpecification requestSpecification = given().log().all().filters(filterList);
        if (contentType != null){
            requestSpecification.contentType(contentType);
        }
        if (headers!=null){
            requestSpecification.headers(headers);
        }
        if (query != null && query.size()>0){
            requestSpecification.formParams(query);
        }else if (body != null){
            requestSpecification.body(body);
        }
        Response response = requestSpecification.request(method, url)
                .then().log().all().extract().response();

        return response;
    }
}
