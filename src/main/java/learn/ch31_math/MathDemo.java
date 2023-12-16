package learn.ch31_math;

public class MathDemo {
    public static void main(String[] args) {
        System.out.println("E: " + Math.E);
        System.out.println("PI: " + Math.PI);
        System.out.println("abs绝对值：" + Math.abs(-8));
        System.out.println("向上取整： " + Math.ceil(3.4));
        System.out.println("向下取整: " + Math.floor(5.9));
        System.out.println("四舍五入: " + Math.round(6.6));
        System.out.println("最大值： " + Math.max(6, 7));
        System.out.println("最小值： " + Math.min(6, 7));
        System.out.println("平方根： " + Math.sqrt(16.0));
        System.out.println("求幂： " + Math.pow(2, 3));

        String[] s1 = new String[10];
        System.out.println(s1[9]);

        String s=new String("hello");
        String t =new String("hello");
        char[] c ={'h','e','l','l','o'};
        System.out.println(s.equals(t));
        System.out.println(t.equals(c));
        System.out.println(s==t);
        System.out.println(t.equals(new String("hello")));
//        System.out.println(t==c);

    }
}
