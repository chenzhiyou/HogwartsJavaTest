package learn.ch22_generic;

import learn.ch07_oop.Person;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add("one");
        System.out.println("没有泛型的list集合" + list);

        // 带有类型要求的list
        List<String> list2 = new ArrayList<>();
        list2.add("one");
//        list2.add();
        Person.show(3);

        Animal animal = new Animal("小白", 2, 1);
        System.out.println(animal);

        Animal<Integer> animal1 = new Animal<>();
        animal1.setSex(1);

//        SubAnimal<String> stringSubAnimal = new SubAnimal();
        SubAnimal subAnimal = new SubAnimal();
        subAnimal.setSex("女生");

//        SubAnimal1<String> stringSubAnimal = new SubAnimal();

        // 泛型方法的调用
        Integer[] integerList = {22,33,44,55,66};
        Animal.show(integerList);

        List<Animal> animals = new ArrayList<>();
        List<SubAnimal> subAnimals = new ArrayList<>();
        List<?> some = new ArrayList<>();
        some = animals; // 可以转换到 List<Animal>
        System.out.println("some为： "+ some);
        some = subAnimals;
        System.out.println("some为： "+ some);
    }
}
