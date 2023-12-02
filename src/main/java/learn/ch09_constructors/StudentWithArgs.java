package learn.ch09_constructors;

public class StudentWithArgs {

    // 声明成员变量
    private String name;
    private int grade;

    // 有参构造方法
    public StudentWithArgs(String name, int grade){
        System.out.println("有参构造方法");
        this.grade = grade;
        this.name = name;
    }

    //构造方法的重载
    public StudentWithArgs(String name){
        System.out.println("只有一个参数的构造方法");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
