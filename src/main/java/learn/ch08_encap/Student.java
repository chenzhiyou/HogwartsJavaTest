package learn.ch08_encap;

public class Student {
    private String name;
    private int age;
    private String gender;

    public String getName() {
        //调用成员方法
        this.show();
        return name;
    }

    public void setName(String name) {
        // 访问成员变量
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void show(){
        System.out.println("这是成员方法");
    }
}
