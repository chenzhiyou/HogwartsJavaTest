package learn.ch14_static;

public class EnginerDemo {
    public static void main(String[] args) {
        Enginer enginer = new Enginer();
        enginer.setName("小李");
        enginer.setWork("java测试工程师");
        // 静态变量，变量值存在一个公共地址--方法区，同一个类的所有实例都可以去访问
//        Enginer.department="测试";
//        Enginer.DEPARTMENT = "测试部";
//        enginer.setDepartment("质量控制");

        Enginer enginer2 = new Enginer();
        enginer2.setName("小七");
        enginer2.setWork("Python测试工程师");
//        enginer2.setDepartment("质量控制");

        enginer.selfIntroduction();
        enginer2.selfIntroduction();
    }
}
