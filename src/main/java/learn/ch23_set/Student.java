package learn.ch23_set;

public class Student implements Comparable<Student>{
    private String name;
    private int age;

    public Student(){

    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        int i =  this.getName().compareTo(o.getName());
        // 姓名相同时比较年龄：
        if (0 ==i){
            return this.getAge() - o.getAge();
        }else {
            return i;
        }
    }
}
