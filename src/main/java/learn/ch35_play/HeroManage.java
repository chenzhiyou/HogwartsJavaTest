package learn.ch35_play;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HeroManage {
    Scanner scanner = new Scanner(System.in);

    // 英雄信息添加
    public void addHero(List<Hero> heroes){
        /**
         * 1、键盘录入英雄信息
         * 2、根据录入的信息创建英雄对象
         * 3、将英雄对象添加到集合中
         * 4、提示添加成功信息
         */

        Integer heroNum = null;
        while (true){
            System.out.println("请输入英雄编号：");
            heroNum= scanner.nextInt();
            boolean flag = isUsed(heroes, heroNum);
            if (flag){
                System.out.println("输入的编码已存在，请重新输入");
            }else {
                break;
            }
        }
        System.out.println("请输入英雄名称：");
        String heroName = scanner.next();
        System.out.println("请输入英雄血量：");
        Integer heroBlood = scanner.nextInt();
        System.out.println("请输入英雄攻击力：");
        Integer heroAttack = scanner.nextInt();
        heroes.add(new Hero(heroNum, heroName, heroBlood, heroAttack));
        System.out.println("添加英雄成功");
    }
    // 英雄信息查看
    public void showHero(List<Hero> heroes){
        /**
         * 方法内遍历集合，将英雄信息进行输出
         */
        System.out.println("编号" + " \t\t"+ "姓名" + " \t\t" + "血量"+ " \t\t" + "攻击力");
        for (Hero hero: heroes){
            if (hero.getHeroName().length() <5){
                String name = hero.getHeroName();
                for (int j = 1; j <(5-hero.getHeroName().length()); j++){
                    name += " ";
                }
            }
            System.out.println(hero.getHeroNum() + " \t\t"+ hero.getHeroName() + " \t\t" + hero.getHeroBlood()+ " \t\t" + hero.getHeroAttack());
        }
    }

    // 更新英雄信息
    public void updateHero(List<Hero> heroes){
        /**
         * 1、方法中接收要修改英雄的编号
         * 2、通过键盘录入英雄对象所需的信息，并创建英雄对象
         * 3、遍历集合，获取每一个英雄对象，和录入的修改英雄编号进行比较
         *      1、如果相同，则使用新英雄对象替换当前英雄对象
         */
        Integer heroNum = null;
        while (true){
            System.out.println("请输入要修改的英雄编号：");
            heroNum= scanner.nextInt();
            boolean flag = isUsed(heroes, heroNum);
            if (!flag){
                System.out.println("要修改的英雄不存在");
            }else {
                for (Hero hero: heroes){
                    if (hero.getHeroNum().equals(heroNum)){
                        System.out.println("请输入英雄名称：");
                        String heroName = scanner.next();
                        hero.setHeroName(heroName);
                        System.out.println("请输入英雄血量：");
                        Integer heroBlood = scanner.nextInt();
                        hero.setHeroBlood(heroBlood);
                        System.out.println("请输入英雄攻击力：");
                        Integer heroAttack = scanner.nextInt();
                        hero.setHeroAttack(heroAttack);
                    }
                }
                System.out.println("修改英雄成功");
                break;
            }
        }
    }

    // 查看血量小于100的英雄名
    public void findLessThan100(List<Hero> heroes){
        List<String> nameList = new ArrayList<>();
        for (Hero hero:heroes){
            if (hero.getHeroBlood() < 100){
                nameList.add(hero.getHeroName());
            }
        }
        System.out.println(nameList);
        // Stream流的方式进行实现
        List<String> names = heroes
                .stream() // 创建Stream
                .filter(hero -> hero.getHeroBlood() <100) // 筛选条件
                .sorted((h1, h2)->Integer.compare(h1.getHeroAttack(), h2.getHeroAttack()))// 比较
                .map(Hero::getHeroName) // String 姓名字符串流
                .collect(Collectors.toList());
        System.out.println(names);
    }
    // 删除英雄
    public void deleteHero(){

    }

    public void fight(List<Hero> heroes){
        // 输出我方出战英雄编号
        System.out.println("请输入我方出战英雄的编号： ");
        Integer mId  = scanner.nextInt();
        // 根据编号获取我方出战英雄对象
        Hero myHero = null;
        for (Hero hero: heroes){
            if (hero.getHeroNum().equals(mId)){
                myHero = hero;
                break;
            }
        }
        //heroes.stream().filter(hero -> hero.getHeroNum().equals(mId));
        // 键盘敌方出战英雄编号
        System.out.println("请输入敌方出战英雄的编号： ");
        Integer enemyId = scanner.nextInt();
        // 根据编号获取敌方出战英雄
        Hero enemyHero = null;

        for (Hero hero: heroes){
            if (hero.getHeroNum().equals(enemyId)){
                enemyHero = hero;
                break;
            }
        }
        //双方开始KO！
        // 打斗后我方英雄的血量 = 我自己的血量 - 敌方的攻击力;
        // 敌方英雄的血量 = 敌方的血量 - 我方的攻击力
        System.out.println("开始KO！");
        // 双方任意一方血量 <= 0 打斗结束
        // 最后输出一下 谁赢
        // 最后剩余血量谁剩的多，谁就赢，要是血量相等，就是平局
        // 最终提示打斗信息
        Integer mBlood = myHero.getHeroBlood();
        Integer enemyBlood = enemyHero.getHeroBlood();
        int result = 0;
        int count = 0;
        while (true){

            if (mBlood <=0 || enemyBlood <=0){
                result = mBlood - enemyBlood;
                System.out.println("战斗结束");
                break;
            }else{
                System.out.println("我"+ myHero.getHeroName()+"的血量为： "+ (mBlood = mBlood-enemyHero.getHeroAttack()));
                System.out.println("敌人"+ enemyHero.getHeroName()+"的血量为： "+(enemyBlood =enemyBlood-myHero.getHeroAttack()));
            }
            count ++;

        }
        if (result >0 ){
            System.out.println("最终打斗了"+count+"回合，结果为：" + myHero.getHeroName()+ "胜出");
        }else if (result <0){
            System.out.println("最终打斗了"+count+"回合，结果为：" + enemyHero.getHeroName()+ "胜出");
        }else{
            System.out.println("平局");
        }
    }

    public boolean isUsed(List<Hero> heroes, Integer id){
        boolean flag = false;
        // 拿到集合内的每一个英雄的对象
        for (Hero hero:heroes){
            if (hero.getHeroNum().equals(id)){
                //说明英雄的编号已经存在
                flag = true;
            }
        }
        return flag;
    }
}
