package com.hogwarts.ch04_loop;

public class ContinueAndBreak {
    public static void main(String[] args) {
        for (int i =1; i <10; i++){
            if (i ==4 ){
                // 控制跳出当前循环，继续执行后续循环
                continue;
            }
            System.out.println(i);
            if (i==8){
                // 结束当前整个循环，执行后续的语句，只能跳出一层循环
                break;
            }
        }
    }
}
