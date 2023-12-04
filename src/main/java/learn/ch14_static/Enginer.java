package learn.ch14_static;

public class Enginer {
    private String name;
    private String work;
    // static修饰的静态变量，被所有的实例都共享
    // final+static 配合一起使用
    public final static String  DEPARTMENT="质量控制";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }


    public void selfIntroduction(){
        System.out.println("我是" + DEPARTMENT + "部门的"+ getName()+",我的工作是"+ getWork());
    }
}
