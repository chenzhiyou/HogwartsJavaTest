package com.hogwarts.interfaceTest.ch09_litemall.api;

import com.jayway.jsonpath.JsonPath;
import io.restassured.filter.Filter;
import io.restassured.http.Header;

import static io.restassured.RestAssured.given;

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
    // 问题： token属于谁？
    public Header token;
    public Filter apiFilter;
    // 角色属性：根据角色的不同初始化对应的不同的token信息
    public String role;


    public Header getToken() {
        return token;
    }

    public void setToken(Header token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // 初始化token的时候需要传入用户名和密码
    public void initToken(String username, String password){
        // 如果是admin，则初始化admin的token信息，如果client，则初始化client的token信息
        if (this.role.equals("admin")){
            String loginUrl = "https://litemall.hogwarts.ceshiren.com/admin/auth/login";
            String loginData = "{\"username\":\""+username+"\",\"password\":\""+password+"\",\"code\":\"\"}";

            System.out.println(loginData);
            String loginResponse = given().body(loginData)
                    .contentType("application/json")
                    .when()
                    .post(loginUrl)
                    .then()
                    .log().all().extract().response().asString();
            String token_value = JsonPath.read(loginResponse, "$.data.token");

            this.token = new Header("X-Litemall-Admin-Token", token_value);
        }else{
            String userLoginUrl = "https://litemall.hogwarts.ceshiren.com/wx/auth/login";
            String userLoginData = "{\"username\":\""+username+"\",\"password\":\""+password+"\",\"code\":\"\"}";
            String userLoginResponse = given().body(userLoginData)
                    .contentType("application/json")
                    .when()
                    .post(userLoginUrl)
                    .then()
                    .log().all().extract().response().asString();
            String token_value = JsonPath.read(userLoginResponse, "$.data.token");
            this.token = new Header("X-Litemall-Token", token_value);
        }

    }

    public void addFilter(){
        this.apiFilter = new ApiFilter(this.getToken());
    }
}
