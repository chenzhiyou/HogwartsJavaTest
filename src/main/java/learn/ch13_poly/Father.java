package learn.ch13_poly;

public class Father {
    public String name = "Father";
    public int age = 99;
    public void eat(){
        System.out.println("Father的eat方法");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void fatherEat(){
        System.out.println("Father在吃饭");
    }

    public void run(){
        System.out.println("Father在跑步");
    }
}
