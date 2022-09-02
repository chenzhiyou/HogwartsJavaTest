package com.hogwarts.interfaceTest.ch09_litemall;

import com.hogwarts.interfaceTest.ch09_litemall.api.BaseLitemallApi;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    public static BaseLitemallApi admin;
    public static BaseLitemallApi user;


    @BeforeAll
    public static void setUpAll(){
        // 问题：market和goods都属于同一个角色，使用的功能，在这个过程中，不需要切换角色
        // 解决方案：角色的初始化不要和具体的业务挂钩 将角色的初始化和业务初始化分开进行
        admin = new BaseLitemallApi();
        admin.setRole("admin");
        admin.initToken("admin123", "admin123");

        user = new BaseLitemallApi();
        user.setRole("client");
        user.initToken("user123", "user123");
    }
}
