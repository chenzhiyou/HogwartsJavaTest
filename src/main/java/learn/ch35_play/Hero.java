package learn.ch35_play;

/**
 * 英雄实体类
 */
public class Hero {
    //英雄编号
    private Integer heroNum;
    // 英雄姓名
    private String heroName;
    // 英雄的血量
    private Integer heroBlood;
    // 英雄的攻击力
    private Integer heroAttack;

    //构造方法
    public Hero() {

    }
    public Hero(Integer heroNum, String heroName, Integer heroBlood, Integer heroAttack) {
        this.heroNum = heroNum;
        this.heroName = heroName;
        this.heroBlood = heroBlood;
        this.heroAttack = heroAttack;
    }

    // get 方法
    // Set 方法
    public Integer getHeroNum() {
        return heroNum;
    }

    public void setHeroNum(Integer heroNum) {
        this.heroNum = heroNum;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public Integer getHeroBlood() {
        return heroBlood;
    }

    public void setHeroBlood(Integer heroBlood) {
        this.heroBlood = heroBlood;
    }

    public Integer getHeroAttack() {
        return heroAttack;
    }

    public void setHeroAttack(Integer heroAttack) {
        this.heroAttack = heroAttack;
    }

    //toString 方法

    @Override
    public String toString() {
        return heroNum +" \t"+ heroName +" \t"+ heroBlood +" \t"+ heroAttack ;
    }
}
