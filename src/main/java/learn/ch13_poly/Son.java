package learn.ch13_poly;

public class Son extends Father{
    public String gender = "male";
    public int age = 10;

    public void eat(){
        System.out.println("son的eat方法");
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }


    public void sonEat(){
        System.out.println("son在吃饭");
    }

    public void run(){
        System.out.println("son在跑步");
    }
}
