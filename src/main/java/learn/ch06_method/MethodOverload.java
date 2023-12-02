package learn.ch06_method;

/**
 * 方法重载 overload
 */
public class MethodOverload {
    public static void main(String[] args) {
        sumTwo(5,10);
        sumThree(3,4,5);

        sum(5,10);
        sum(3,4,5);
    }

    public static int sumTwo(int a, int b){
        System.out.println("有2个参数相加");
        return a+b;
    }

    public static int sumThree(int a, int b, int c){
        System.out.println("有3个参数相加");
        return a+b+c;
    }

    public static int sum(int a, int b){
        System.out.println("有2个参数相加");
        return a+b;
    }

    public static int sum(int a, int b, int c){
        System.out.println("有3个参数相加");
        return a+b+c;
    }
}
