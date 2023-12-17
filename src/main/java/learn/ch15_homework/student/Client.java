package learn.ch15_homework.student;

import learn.ch15_homework.entity.Student;

import java.util.List;
import java.util.Scanner;

public class Client {
    // 面向接口编程
    private final StudentManager studentManager;

    public Client(StudentManager studentManager){
        this.studentManager = studentManager;
    }

    public void show(Integer studentId){
        System.out.println(studentManager.getStudent(studentId));
    }

    public void showAll(){
        List<Student> studentAll = studentManager.getStudentALl();
        int size = studentAll.size();
        for (int i = 0; i <size; i++){
            System.out.println(i + 1 + "." + studentAll.get(i));
        }
    }

    public void run(){
        studentManager.initData();
        final Integer SHOW_FLAG = 1;
        final Integer ADD_FLAG = 2;
        final Integer DEL_FLAG = 3;
        final Integer EXIT_FLAG = 4;
        System.out.println("--------欢迎来到学员信息管理系统--------");

        Scanner scanner = new Scanner(System.in);
        while (true){
            try{
                System.out.println("1 根据学号查看学生信息");
                System.out.println("2 添加学生");
                System.out.println("3 根据学号删除学员后，查看所有学员信息");
                System.out.println("4 退出系统");
                System.out.println("请输入你的选择：");
                Integer fun = scanner.nextInt();
                if (fun.equals(SHOW_FLAG)){
                    System.out.println("根据学号查看学员信息");
                    System.out.println("请输入要查找的学员编号：");
                    Integer studentId = scanner.nextInt();
                    this.show(studentId);
                }else if (fun.equals(ADD_FLAG)){
                    System.out.println("添加学生");
                    System.out.println("请输入学员编号");
                    Integer studentId = scanner.nextInt();
                    System.out.println("请输入学员姓名");
                    String studentName = scanner.next();
                    System.out.println("请输入学员性别");
                    String studentSex = scanner.next();
                    studentManager.addStudent(studentId, studentName, studentSex);
                }else if (fun.equals(DEL_FLAG)){
                    System.out.println("根据学号删除学员后，查看所有学员信息");
                    System.out.println("请输入要删除的学员编号：");
                    Integer studentId = scanner.nextInt();
                    studentManager.deleteStudent(studentId);
                }else if (fun.equals(EXIT_FLAG)){
                    System.exit(0);
                }else {
                    System.out.println("无该操作选项，请重新输入");
                }
            }
            catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
