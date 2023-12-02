package learn.ch08_encap;

public class Demo {
    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(23);
        student.setName("小王");

        System.out.println(student.getName());
    }
}
