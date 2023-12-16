package learn.ch15_homework;

import java.util.LinkedList;
import java.util.List;

/**
 * 学生信息管理类
 */
public class StudentManagement {

    /**
     * 学生信息存储列表
     */
    private List<Student> students = new LinkedList<>();

    /**
     * 查询全部学生信息
     * @return
     */
    public List<Student> getStudents() {
        for (int i =0; i<students.size(); i++){
            System.out.println(students.get(i));
        }
        return students;
    }


    /**
     * 根据学号查询学生
     * @param id 学号
     */
    public void getStudentById(int id) {
        boolean stdExit = false;
        for (Student student : students) {
            if (student.getId() == id) {
//                System.out.println("删除的学员为： " +student);
                System.out.println(student);
                stdExit = true;
            }
        }
        if (!stdExit){
            System.out.println("学生不存在");
        }
    }

    /**
     * 添加学生
     * @param id 学号
     * @param name 学生姓名
     * @param sex 学生性别
     */
    public void addStudent(int id, String name, String sex){
            Student student = new Student();
            student.setId(id);
            student.setSex(sex);
            student.setName(name);
            students.add(student);
            System.out.println("添加学员成功");
    }

    /**
     * 根据学生学号删除学生
     * @param id 学号
     */
    public void deleteStudent(int id){
        boolean rmFlag = false;
        for (Student student : students){
            if (student.getId() == id){
//                System.out.println("删除的学员为： " +student);
                students.remove(student);
                rmFlag = true;
            }
        }
        if (!rmFlag){
            System.out.println("学生不存在");
        }
        System.out.println("删除后的学员信息：");
        getStudents();
    }

}
