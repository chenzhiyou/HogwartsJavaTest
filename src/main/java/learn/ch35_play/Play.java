package learn.ch35_play;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Play {
    public static void showMenu(){
        System.out.println("--------欢迎来到回合制游戏--------");
        System.out.println("1 创建英雄");
        System.out.println("2 查看英雄信息");
        System.out.println("3 查看血量小于100的英雄名");
        System.out.println("4 打斗");
        System.out.println("5 修改英雄信息");
        System.out.println("6 删除英雄");
        System.out.println("7 退出系统");
    }
    public static void main(String[] args) {
        HeroManage heroManage =new HeroManage();
        //初始化英雄列表，list add 添加元素
        List<Hero> heroes = new ArrayList<>();
        heroes.add(new Hero(1001, "小兵", 30, 1));
        heroes.add(new Hero(1002, "辅助", 300, 10));
        heroes.add(new Hero(1003, "肉盾", 500, 30));

        while (true){
            showMenu();
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入你的选择");
            String choice = scanner.nextLine();
            //如果不支持，可以进行类型转换
//            int choiceInt = Integer.valueOf(choice);
            switch (choice){
                case "1":
                    System.out.println("创建英雄实现");
                    heroManage.addHero(heroes);
                    break;
                case "2":
                    System.out.println("查看英雄信息实现");
                    heroManage.showHero(heroes);
                    break;
                case "3":
                    System.out.println("查看血量小于100的英雄名实现");
                    heroManage.findLessThan100(heroes);
                    break;
                case "4":
                    System.out.println("打斗实现");
                    heroManage.fight(heroes);
                    break;
                case "5":
                    System.out.println("修改英雄信息实现");
                    heroManage.updateHero(heroes);
                    break;
                case "6":
                    System.out.println("删除英雄实现");
                    heroManage.deleteHero();
                    break;
                case "7":
                    // JVM退出
                    System.out.println("退出系统实现");
                    System.exit(0);
            }
        }
        // 主界面

    }
}
