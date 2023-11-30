package learn.ch02_operator;

public class MathDemo {
    public static void main(String[] args) {
        int a = 20;
        int b = 10;
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println(a % b);
        System.out.println(a++);
        System.out.println(b--);

        System.out.println("a==b:" + (a==b));
        System.out.println("a!=b:" + (a!=b));
        System.out.println("a>b:" + (a>b));
        System.out.println("a<b:" + (a<b));
        System.out.println("a>=b:" + (a>=b));
//        System.out.println("a==b:" + (a==b));
    }
}
