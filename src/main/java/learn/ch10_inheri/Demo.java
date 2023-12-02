package learn.ch10_inheri;

public class Demo {
    public static void main(String[] args) {
        Student student = new Student();
        Teacher teacher = new Teacher();

        student.name = "小王";
        teacher.name = "小李";
        student.eat();
        student.study();
        teacher.eat();
        teacher.teach();
    }
}
