package com.hogwarts.interfaceTest.ch10_wework_interface.po;

import io.restassured.builder.ResponseBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.filter.log.LogDetail;
import io.restassured.internal.print.RequestPrinter;
import io.restassured.internal.print.ResponsePrinter;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.slf4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import static io.restassured.config.LogConfig.logConfig;
import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class ApiFilter extends BaseApi implements Filter {
    public String apiLogPath = "api.log";

    @Override
    public Response filter(
            FilterableRequestSpecification filterableRequestSpecification,
            FilterableResponseSpecification filterableResponseSpecification,
            FilterContext filterContext) {
        // 动态添加全局参数： --登录token
        filterableRequestSpecification.queryParam("access_token", GetToken.getAccessToken());
        filterableRequestSpecification.contentType("application/json");
        Response response = filterContext.next(filterableRequestSpecification, filterableResponseSpecification);
        // 获取请求相关日志信息
        try {
            String requestPrintInfo = RequestPrinter.print(
                    filterableRequestSpecification,
                    filterableRequestSpecification.getMethod(),
                    filterableRequestSpecification.getURI(),
                    LogDetail.ALL,
                    logConfig().blacklistedHeaders(),
                    new PrintStream(new FileOutputStream(apiLogPath, true)), true);
            logger.info("接口请求日志"+requestPrintInfo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 响应修改
        Response responseAction = new ResponseBuilder().clone(response).build();
        // 响应相关的日志信息
        try {
            String responsePrintInfo = ResponsePrinter.print(
                    responseAction,
                    responseAction.body(),
                    new PrintStream(new FileOutputStream(apiLogPath, true)),
                    LogDetail.ALL,true,
                    logConfig().blacklistedHeaders());

            logger.info("接口响应日志"+responsePrintInfo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return responseAction;
    }
}
