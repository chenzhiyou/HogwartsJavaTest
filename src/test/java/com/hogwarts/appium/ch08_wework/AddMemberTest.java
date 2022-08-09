package com.hogwarts.appium.ch08_wework;

import com.hogwarts.appium.ch07_po.page.XueQiuAPP;
import com.hogwarts.appium.ch08_wework.page.WeWorkMainPage;
import com.util.FakerUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 打造测试框架的需求与价值：
 *      领域模型适配：封装业务实现，实现业务管理
 *      提高效率：降低用例维护成本，提高执行效率
 *      增强功能：解决已有框架不满足的情况
 * 自动化框架应具备的功能：
 *      支持管理用例，运行用例
 *      支持查找元素/定位元素，对元素/页面进行各种操作
 *      支持生成测试报告
 *      能够时间功能的复用
 *      当页面有异常弹窗的时候，可以进行有效的处理
 *      当用例失败，需要添加失败时的日志，截图等信息放在测试报告中
 *      多设备并发
 *      支持平台化
 * 项目结构：
 *      框架层：yaml解析、日志收集、数据驱动、ini配置文件、用例数据、报告管理
 *      基础层：基础driver封装、查找封装、操作封装、领域模型
 *      业务层/PO层：Page封装，各个页面的PO
 *      用例层：测试用例集、各个case
 */
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

    @Test
    public void deleteMemberTest(){
        List<String> searchList = weWork
                .switchToContactPage()
                .goToSearchPage()
                .searchMember()
                .goToResult()
                .goToMemberInfoEditPage()
                .editMember()
                .deleteMember()
                .noResult();
        assertTrue(searchList.contains("无搜索结果"));
    }

    @Test
    public void ClockInTest() throws InterruptedException {
        weWork.switchToWorkPage()
                .goToClockInPage()
                .Clock();
    }

}
