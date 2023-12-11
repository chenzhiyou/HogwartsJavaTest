package learn.ch15_homework;

public class StudentManagementMain {
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        studentManagement.addStudent(1001, "张三", "男");
        studentManagement.addStudent(1002, "莉丝", "女");
        studentManagement.addStudent(1003, "王武", "男");
        System.out.println("添加的学员信息：");
        studentManagement.getStudents();
        studentManagement.deleteStudent(1002);
    }
}
