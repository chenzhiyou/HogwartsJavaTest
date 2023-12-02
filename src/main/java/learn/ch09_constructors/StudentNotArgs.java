package learn.ch09_constructors;

public class StudentNotArgs {

    // 声明成员变量
    private String name;
    private int grade;

    // 显示声明无参构造方法
    public StudentNotArgs(){
        System.out.println("显示声明无参构造方法");
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
