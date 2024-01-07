package com.hogwarts.learn.ch25_play;

import learn.ch35_play.Hero;
import learn.ch35_play.HeroManage;
import learn.ch35_play.Play;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("游戏角色测试")
public class PlayTest {
    static HeroManage heroManage;
    static List<Hero> heroes = new ArrayList<>();

    @BeforeAll
    static void beforeAll(){
        System.out.println("beforeAll");
        heroManage = new HeroManage();
        //初始化英雄列表，list add 添加元素
        heroes.add(new Hero(1001, "小兵", 30, 1));
        heroes.add(new Hero(1002, "辅助", 300, 10));
        heroes.add(new Hero(1003, "肉盾", 500, 30));
    }

    @AfterAll
    static void afterAll(){
        System.out.println("afterAll");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("beforeEach");
    }

    @AfterEach
    void afterEach(){
        System.out.println("afterEach");
    }

    @Test
    @DisplayName("英雄列表测试")
    void getHeros(){
        System.out.println("getHeros");
        heroManage.showHero(heroes);

    }

    @Test
    void getHero(){
//        Hero hero = heroManage.showHero("小兵");

    }




}
