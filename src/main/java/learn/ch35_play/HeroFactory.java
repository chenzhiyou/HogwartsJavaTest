package learn.ch35_play;

/**
 * 工厂设计模式
 */
public class HeroFactory {

    public static Hero getHero(String name){
        if ("小兵".equals(name)){
            return new Hero(1001, "小兵", 30, 1);
        }else if ("辅助".equals(name)){
            return new Hero(1002, "辅助", 300, 10);
        }else if ("肉盾".equals(name)){
            return new Hero(1003, "肉盾", 500, 30);
        }else {
            System.out.println("没有找到对应的英雄");
            return null;
        }
    }
}
