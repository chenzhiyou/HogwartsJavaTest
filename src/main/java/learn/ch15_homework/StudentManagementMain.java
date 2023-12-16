package learn.ch15_homework;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManagementMain {
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        boolean flag =true;

        while (flag){
            System.out.println("--------欢迎来到学员信息管理系统--------");
            System.out.println("1 根据学号查看学生信息");
            System.out.println("2 添加学生");
            System.out.println("3 根据学号删除学员后，查看所有学员信息");
            System.out.println("4 退出系统");
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入你的选择：");
            int num = 0;
            try{
                 num = scanner.nextInt();
            }catch (InputMismatchException inputMismatchException){
                break;
            }

            switch (num){
                case 1:
                    System.out.println("根据学号查看学员信息");
                    System.out.println("请输入要查找的学员编号：");
                    int studentNum= scanner.nextInt();
                    studentManagement.getStudentById(studentNum);
                    break;
                case 2:
                    System.out.println("添加学生");
                    System.out.println("请输入学员编号");
                    studentNum = scanner.nextInt();
                    System.out.println("请输入学员姓名");
                    String studentName = scanner.next();
                    System.out.println("请输入学员性别");
                    String studentSex = scanner.next();
                    studentManagement.addStudent(studentNum, studentName, studentSex);
                    break;
                case 3:
                    System.out.println("根据学号删除学员后，查看所有学员信息");
                    System.out.println("请输入要删除的学员编号：");
                    studentNum = scanner.nextInt();
                    studentManagement.deleteStudent(studentNum);
                    break;
                case 4:
                    System.out.println("退出系统");
                    System.out.println("期待下次再来");
                    flag = false;
                    break;
                default:
                    flag = false;

            }

        }

    }
}
