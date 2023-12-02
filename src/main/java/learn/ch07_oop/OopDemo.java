package learn.ch07_oop;

import java.util.Arrays;

public class OopDemo {
    public static void main(String[] args) {
        String[] name = new String[]{"张三", "李四", "王五", "赵六"};
        // 面向过程的方式
        for (int i =0; i< name.length; i++){
            if (i==0 && i !=(name.length-1)){
                System.out.print("[");
                System.out.print(name[i] +",");
            }else if (i ==(name.length-1)){
                System.out.print(name[i] +"]");
            }else {
                System.out.print(name[i] +",");
            }

        }
        System.out.println();
        //使用面向对象的方式
        System.out.println(Arrays.toString(name));
    }
}
