package learn.ch18_langp;

public class IntegerDemo {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.TYPE);

        // 构造方法声明
        Integer integer1 = new Integer(19);
        Integer integer2 = new Integer("22");
        System.out.println(integer1);
        System.out.println(integer2);

        // int类型转换为Integer
        int i1 = 99;
        Integer integer3 = Integer.valueOf(i1);
        System.out.println(integer3);
        System.out.println(Integer.valueOf("99"));

        // Integer类型转换为int
        int i2 = integer1.intValue();
        System.out.println(i2);

        // String类型转换为int
        String s1 = "888";
        System.out.println(Integer.parseInt(s1));
    }
}
