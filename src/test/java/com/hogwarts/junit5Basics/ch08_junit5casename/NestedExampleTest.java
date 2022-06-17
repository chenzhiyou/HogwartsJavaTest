package com.hogwarts.junit5Basics.ch08_junit5casename;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NestedExampleTest {

    /**
     * @Nested 需要结合Class使用, 内部需要与测试用例结合
     */

    @Nested
    class AuthorityManage{
        @Test
        void authorityManage(){
            System.out.println("权限管理");
        }

        @Test
        void managerManage(){
            System.out.println("管理员管理");
        }
    }

    @Nested
    class UserManager{
        @Test
        void userManage(){
            System.out.println("用户管理");
        }
    }

    @Nested
    class employeeManage{
        @Test
        void employeeManage(){
            System.out.println("权限管理");
        }
    }








}
