package learn.ch15_homework.student.impl;

import learn.ch15_homework.enums.SexEnum;
import learn.ch15_homework.exceptions.StudentIdAlreadyExitException;
import learn.ch15_homework.exceptions.StudentIdNotExitException;
import learn.ch15_homework.exceptions.StudentSexInputException;
import learn.ch15_homework.entity.Student;
import learn.ch15_homework.student.StudentManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentManagerImpl implements StudentManager {

    private static Map<Integer, Student> students;
    @Override
    public void initData() {
        students = new HashMap<>();
    }

    @Override
    public void addStudent(Integer id, String name, String sex) {
        SexEnum se = null;
        // 对学生ID进行判断
        if (students.containsKey(id)){
            throw new StudentIdAlreadyExitException();
        }
        // 判断性别
        if (sex.equals(SexEnum.man.getChineseName())){
            se = SexEnum.man;
        }else if(sex.equals(SexEnum.female.getChineseName())){
            se = SexEnum.female;
        }else {
            throw new StudentSexInputException();
        }
        students.put(id, new Student(id, name, sex));

        System.out.println("添加学员成功");
    }

    @Override
    public void deleteStudent(Integer id) {
        if (students.containsKey(id)){
            students.remove(id);
        }else {
            throw new StudentIdNotExitException();
        }
        System.out.println("学生删除成功");
    }

    public List<Student> getStudentAll(){
        return new ArrayList<>(students.values());
    }
    @Override
    public Student getStudent(Integer id) {
        if (!students.containsKey(id)){
            throw new StudentIdNotExitException();
        }
        return students.get(id);
    }

    @Override
    public List<Student> getStudentALl() {
        return null;
    }
}
