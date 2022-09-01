package com.hogwarts.interfaceTest.ch09_litemall.filter;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import static com.hogwarts.interfaceTest.ch09_litemall.filter.Log.log;

// filter的定义
public class FilterDemo implements Filter{
    @Override
    public Response filter(
            FilterableRequestSpecification filterableRequestSpecification,
            FilterableResponseSpecification filterableResponseSpecification,
            FilterContext filterContext) {
        // 原始的请求信息
        // 添加一个头信息
        filterableRequestSpecification.header("name", "ad");
        // 设置基地址
        filterableRequestSpecification.baseUri("https://httpbin.ceshiren.com");

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
        log.debug("接口响应" + responseInfo);
        return response;
    }
}
