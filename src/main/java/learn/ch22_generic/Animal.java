package learn.ch22_generic;

// 自定义泛型类
public class Animal<T> {
    private String name;
    private int age;
    private T sex;

    public Animal(){

    }
    public Animal(String name, int age, T sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
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

    public T getSex() {
        return sex;
    }

    public void setSex(T sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    // 泛型方法
    public static <T1> void show(T1[] i){
        for (T1 t: i){
            System.out.println(t);
        }
    }
}
