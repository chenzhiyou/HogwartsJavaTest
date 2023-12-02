package learn.ch06_method;

public class MethodCall {
    // 方法的调用
    public static void main(String[] args) {
        sum(5, 10);// 单独调用
        System.out.println(sum(5, 10)); // 打印调用
        int num = sum(5, 10); // 赋值调用
    }

    public static int sum(int a, int b){
        // 方法体
        int result = a+b;
        return result;
    }
}
