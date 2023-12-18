package learn.ch15_homework.student;

import learn.ch15_homework.enums.SexEnum;
import learn.ch15_homework.exceptions.StudentIdAlreadyExitException;
import learn.ch15_homework.exceptions.StudentIdNotExitException;
import learn.ch15_homework.exceptions.StudentSexInputException;
import learn.ch15_homework.entity.Student;

import java.util.*;

/**
 * 学生信息管理类
 */
public class StudentManagement {

    /**
     * 学生信息存储列表
     */
//    private List<Student> students = new LinkedList<>();
    private static Map<Integer, Student> students;

    /**
     * 初始化数据
     */
    public void initData(){
        students = new HashMap<>();
    }

    /**
     * 查询全部学生信息
     * @return
     */
    public void getStudents() {
        List<Student> studentAll = this.getStudentAll();
        for (int i = 0; i <this.getStudentAll().size(); i++){
            System.out.println(i+1+"." + studentAll.get(i));
        }
    }

    public List<Student> getStudentAll(){
        return new ArrayList<>(students.values());
    }

    /**
     * 根据学号查询学生
     * @param id 学号
     */
    public Student getStudentById(Integer id) {
        if (!students.containsKey(id)){
            throw new StudentIdNotExitException();
        }
        return students.get(id);

    }

    /**
     * 学生信息展示
     * @param id
     */
    public void show(Integer id){
        System.out.println(this.getStudentById(id));
    }

    /**
     * 添加学生
     * @param id 学号
     * @param name 学生姓名
     * @param sex 学生性别
     */
    public void addStudent(int id, String name, String sex){
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

    /**
     * 根据学生学号删除学生
     * @param id 学号
     */
    public void deleteStudent(int id){
        if (students.containsKey(id)){
            students.remove(id);
        }else {
            throw new StudentIdNotExitException();
        }
        System.out.println("学生删除成功");
    }


    public void run(){
        this.initData();
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
                    this.addStudent(studentId, studentName, studentSex);
                }else if (fun.equals(DEL_FLAG)){
                    System.out.println("根据学号删除学员后，查看所有学员信息");
                    System.out.println("请输入要删除的学员编号：");
                    Integer studentId = scanner.nextInt();
                    this.deleteStudent(studentId);
                }else if (fun.equals(EXIT_FLAG)){
                    System.exit(0);
                }else {
                    System.out.println("无该操作选项，请重新输入");
                }
            }
            catch (RuntimeException e){
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
    }
}
