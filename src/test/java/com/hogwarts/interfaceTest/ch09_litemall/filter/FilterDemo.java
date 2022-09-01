package com.hogwarts.interfaceTest.ch09_litemall.filter;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

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
        // 真实发起请求
        Response response = filterContext.next(filterableRequestSpecification, filterableResponseSpecification);
        return response;
    }
}
