package com.hogwarts.interfaceTest.ch09_litemall.api;

/**
 * 输入信息(model)
 *      输入信息表示接口请求过程中和业务相关的具体数据信息
 *      例如：商品model
 *          简单的参数：参数
 *          正常： 实体类
 *          非常复杂的： yaml、json等文件
 * 接口信息(api)
 * 测试用例(testcase)
 * 接口自动化测试的过滤器(filter)
 *      使用场景：
 *          日志信息
 *          请求头的配置
 *      过滤器的使用：
 *          定义：实现filter接口，重写filter方法(请求信息、响应信息、过滤器信息)
 *          使用：given.filter(重写的filter实例)
 */
public class BaseLitemallApi {
}
