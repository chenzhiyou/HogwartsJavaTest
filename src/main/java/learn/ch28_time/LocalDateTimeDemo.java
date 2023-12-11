package learn.ch28_time;

import java.time.LocalDateTime;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        LocalDateTime timeNow = LocalDateTime.now();
        System.out.println("当前时间为： "+ timeNow);
        LocalDateTime timeOf = LocalDateTime.of(2022,2,14,21,30,30);
        System.out.println("自定义时间为： "+ timeOf);

        System.out.println("当月第几天 "+ timeNow.getDayOfMonth());
        System.out.println("本周第几天 "+ timeNow.getDayOfWeek());
        System.out.println("月份"+ timeNow.getMonth());

    }
}
