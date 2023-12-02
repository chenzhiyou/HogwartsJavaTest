package learn.ch10_inheri;

public class Person {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void  eat(){
        System.out.println(this.name + "在吃饭");
    }
}
