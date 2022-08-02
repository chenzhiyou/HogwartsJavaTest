package com.hogwarts.appium.ch08_wework;

import com.hogwarts.appium.ch07_po.page.XueQiuAPP;
import com.hogwarts.appium.ch08_wework.page.WeWorkMainPage;
import com.util.FakerUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;

public class AddMemberTest {
    public static WeWorkMainPage weWork;
    public static String memberName = FakerUtil.get_name();
    public static String memberPhone = FakerUtil.get_zh_phone();

    @BeforeAll
    public static void Before(){

        weWork = new WeWorkMainPage().startApp();
    }

    @Test
    public void AddMemberTest(){
            weWork
                .switchToContactPage()// 切换到通讯录界面
                .goToChooseContactMethodPage() // 点击添加成员进入到选择添加方式界面
                .goToEditContactPage()
                .addMember(memberName, memberPhone)
                .backToContactPage();
    }

    @Test
    public void SearchMemberTest(){
        String name = weWork
                .switchToContactPage()
                .goToSearchPage()
                .searchMember()
                .goToResult()
                .getMemberName();
        System.out.println(name);
    }


}
