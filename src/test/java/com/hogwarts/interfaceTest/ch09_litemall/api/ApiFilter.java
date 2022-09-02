package com.hogwarts.interfaceTest.ch09_litemall.api;

import com.jayway.jsonpath.JsonPath;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

import static com.hogwarts.interfaceTest.ch09_litemall.filter.Log.log;
import static io.qameta.allure.Allure.addAttachment;
import static io.restassured.RestAssured.given;

/**
 * 问题1：出现多个角色，多个token，如何处理
 * 问题2： 多次调用login请求获取token，影响用例执行效率
 * 解决方案：添加一个初始化token的方法，并调通，并添加一个初始化filter的方法，传入token给filter
 */
public class ApiFilter implements Filter{

    public String token;

    public ApiFilter(String token){
        this.token = token;
    }
    @Override
    public Response filter(
            FilterableRequestSpecification filterableRequestSpecification,
            FilterableResponseSpecification filterableResponseSpecification,
            FilterContext filterContext) {
        // 原始的请求信息
        // 添加配置信息

        filterableRequestSpecification.contentType("application/json");
        // 添加一个头信息
        // 问题： filter依然需要token
        filterableRequestSpecification.header("X-Litemall-Admin-Token", token);
        // 设置基地址 等于配置域名
        filterableRequestSpecification.baseUri("https://litemall.hogwarts.ceshiren.com");

        // 请求信息：
        String requestsInfo = filterableRequestSpecification.getMethod() + ""
                + filterableRequestSpecification.getURI()
                + "\n Request Body =>"
                + filterableRequestSpecification.getBody();

        // 真实发起请求,获取响应对象
        Response response = filterContext.next(filterableRequestSpecification, filterableResponseSpecification);

        // 响应数据
        String responseInfo = "\n Response Status =>"
                + response.getStatusCode()
                + " " + response.getStatusLine()
                + "\n Response Body =>" + response.getBody().asPrettyString();

        // 日志的配置： 每个接口在调用过程中，自动打印日志信息
        log.debug("接口请求" + requestsInfo);
        addAttachment("接口请求", requestsInfo);
        log.debug("接口响应" + responseInfo);
        addAttachment("接口响应", responseInfo);
        return response;
    }
}
