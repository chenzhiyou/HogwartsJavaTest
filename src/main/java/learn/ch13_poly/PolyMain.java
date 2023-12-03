package learn.ch13_poly;

public class PolyMain {
    public static void main(String[] args) {
        //正常写法：
        Son son = new Son();
        son.eat();

        //多态写法：父类引用指向子类对象
        Father father = new Son();
        father.eat();

        // 访问成员变量
        System.out.println(father.name); // 输出father的name
        // 重名优先查找父类
        System.out.println(father.age);
        // 访问子类独有的变量(不可以)
//        System.out.println(father.gender);

        //
        System.out.println(father.getAge());

        // 调用父类独有方法
        father.fatherEat(); // 子类没有，父类有，向上找父类

        //调用重写的方法
        father.run();

        // 调用子类独有方法 子类有，父类没有，无法调用
//        father.sonEat();

        // 向上转型
        Person person = new DownWorker();
        person.run();
        System.out.println(person instanceof DownWorker);
        // 向下转型 子类引用指向父类
        if (person instanceof DownWorker){
            DownWorker worker = (DownWorker) person;
            worker.work();
        }

    }
}
