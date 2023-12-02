package learn.ch09_constructors;

public class StudentDefault {
    // 声明成员变量
    private String name;
    private int grade;

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
// 没有构造方法，系统会自动提供构造方法
}
