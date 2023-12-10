package learn.ch23_set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        Set<String> stringSet = new TreeSet<>();
        System.out.println("stringSet: "+ stringSet);
        boolean hello = stringSet.add("aa");
        System.out.println("是否添加成功："+ hello);
        System.out.println("stringSet: "+ stringSet);
        stringSet.add("bb");
        stringSet.add("cc");
        System.out.println("stringSet: "+ stringSet);

        Set<Student> studentSet = new TreeSet<>();
        System.out.println("studentSet: "+ studentSet);
        studentSet.add(new Student("gaigai", 30));
        studentSet.add(new Student("java", 35));
        System.out.println("studentSet: "+ studentSet);

        // o1是添加对象，O2是原有对象
        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int i =  o1.getName().compareTo(o2.getName());
                // 姓名相同时比较年龄：
                if (0 ==i){
                    return o1.getAge() - o2.getAge();
                }else {
                    return i;
                }
            }
        };

//        (Student o1, Student o2) ->{o1.getAge() - o2.getAge()}
        // 匿名表达式写法
        Comparator<Student> comparator1 =
                (Student o1, Student o2) ->{return o1.getAge() - o2.getAge();};
        Set<Student> students = new TreeSet<>(comparator);
        students.add(new Student("gaigai", 30));
        students.add(new Student("java", 49));
        students.add(new Student("java", 35));
        System.out.println("students: "+ students);

        Set<Student> studentTreeSet = new TreeSet<>(comparator1);
        studentTreeSet.add(new Student("gaigai", 30));
        studentTreeSet.add(new Student("java", 49));
        studentTreeSet.add(new Student("java", 35));
        System.out.println("studentTreeSet: "+ studentTreeSet);
    }
}
