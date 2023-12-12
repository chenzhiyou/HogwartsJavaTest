package learn.ch32_scanner;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        // 实例化scanner对象
        Scanner scanner = new Scanner(System.in);
        // 接收键盘输入
        System.out.println("请输入一段文本:");
        String msg = scanner.next();
        System.out.println(msg);

        System.out.println("请输入一个数字:");
        int num = scanner.nextInt();
        System.out.println(num);
        if (scanner.hasNextInt()){
            System.out.println("太棒了，果然还是数字");
        }else {
            System.out.println("不是数字，程序结束");
        }

    }
}
