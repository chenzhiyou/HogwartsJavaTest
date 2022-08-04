package com.hogwarts.appium.ch07_po;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.hogwarts.appium.ch07_po.entity.SearchDto;
import com.hogwarts.appium.ch07_po.entity.SearchListDto;
import com.hogwarts.appium.ch07_po.page.XueQiuAPP;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * PO模式六大原则
 *      分为三层：
 *          具体业务层
 *          公共业务层
 *          和业务无关的公共方法层
 */
public class POTest {
    public static XueQiuAPP xueQiuAPP;

    @BeforeAll
    public static void Before(){
        xueQiuAPP = new XueQiuAPP().startApp();
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("search xueqiu")
    @Description("测试用例： 雪球搜索阿里巴巴股票价格")
    public void searchTest(SearchDto searchDto){
        String price = xueQiuAPP // 启动雪球APP
                .toSearchPage() // 点击搜索跳转到搜索页面
                .toSearchResultPage(searchDto.getText())// 搜索页面输入内容，跳转到搜索结果页面
                .getPrice(); // 获取当前股票的金额
        Double priceDouble = Double.valueOf(price);
        assertThat(priceDouble,is(closeTo(searchDto.getPriceEnd()*(1-0.1), searchDto.getPriceEnd()*(1+0.1))));

    }
    static List<SearchDto> searchTest(){
        List<SearchDto> datas = getSearchYaml().getDatas();
        return datas;
    }

    @AfterEach
    public void afterEach(){
        xueQiuAPP.back();
    }

    @AfterAll
    public static void after(){
        xueQiuAPP.quite();
    }

    // 读取yaml文件
    private static SearchListDto getSearchYaml(){
        SearchListDto searchListDto;
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        // 需要解析成的类
        TypeReference<SearchListDto> typeReference = new TypeReference<SearchListDto>(){};
        try {
            searchListDto = objectMapper.readValue(Paths.get("src/test/resources/data/seaarch.yaml").toFile(), typeReference);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return searchListDto;
    }
}
