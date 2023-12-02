package learn.ch09_constructors;

/**
 * 构造方法的使用
 */
public class Demo {
    public static void main(String[] args) {
        StudentDefault studentDefault = new StudentDefault();
        System.out.println("默认构造方法");
        System.out.println(studentDefault.getName());
        System.out.println(studentDefault.getGrade());
        StudentNotArgs studentNotArgs = new StudentNotArgs();

        System.out.println("无参构造方法");
        System.out.println(studentNotArgs.getName());
        System.out.println(studentNotArgs.getGrade());


        StudentWithArgs studentWithArgs = new StudentWithArgs("小王", 23);

        System.out.println("有参构造方法");
        System.out.println(studentWithArgs.getName());
        System.out.println(studentWithArgs.getGrade());

        StudentWithArgs studentWithArgs1 = new StudentWithArgs("小李");
        System.out.println("有1个参构造方法");
        System.out.println(studentWithArgs1.getName());
        System.out.println(studentWithArgs1.getGrade());
    }
}
