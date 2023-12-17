package learn.ch15_homework.student;

import learn.ch15_homework.entity.Student;

import java.util.List;

public interface StudentManager {
    /**
     * 初始化数据
     */
    void initData();

    /**
     * 添加学生信息
     */
    void addStudent(Integer id, String name, String sex);

    /**
     * 通过ID删除学生信息
     */
    void deleteStudent(Integer id);

    /**
     * 获取学员信息
     */
    Student getStudent(Integer id);

    /**
     * 返回所有学生信息
     */
    List<Student> getStudentALl();
}
