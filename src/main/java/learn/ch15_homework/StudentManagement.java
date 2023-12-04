package learn.ch15_homework;

public class StudentManagement {
    public void addStudent(int id, String name, String sex){
        Student student = new Student();
        student.setId(id);
        student.setSex(sex);
        student.setName(name);
        System.out.println(student.toString());
    }

}
