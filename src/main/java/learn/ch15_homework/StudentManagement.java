package learn.ch15_homework;

import java.util.LinkedList;
import java.util.List;

public class StudentManagement {
    private List<Student> students = new LinkedList<>();

    public List<Student> getStudents() {
        for (int i =0; i<students.size(); i++){
            System.out.println(students.get(i));
        }
        return students;
    }


    public void addStudent(int id, String name, String sex){
        Student student = new Student();
        student.setId(id);
        student.setSex(sex);
        student.setName(name);
        students.add(student);
    }

    public void deleteStudent(int id){
        for (Student student : students){
            if (student.getId() == id){
//                System.out.println("删除的学员为： " +student);
                students.remove(student);
            }
        }
        System.out.println("删除后的学员信息：");
        getStudents();
    }

}
