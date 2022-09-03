package com.hogwarts.interfaceTest.ch10_wework_interface;

import com.util.FakerUtil;
import org.junit.jupiter.api.Test;

public class FakerTest {

    @Test
    public void test(){
        String departmentName = FakerUtil.get_name()+FakerUtil.get_zh_phone();
        System.out.println(departmentName);

        int orderNum = FakerUtil.getNum(30);
        System.out.println(orderNum);

    }
}
