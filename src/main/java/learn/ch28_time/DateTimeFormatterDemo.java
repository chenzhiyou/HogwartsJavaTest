package learn.ch28_time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class DateTimeFormatterDemo {
    public static void main(String[] args) {
        String format = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        // 将日期时间对象->字符串
        String timeStr = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(timeStr);

        // 字符串->日期时间对象
        TemporalAccessor acc = dateTimeFormatter.parse(timeStr);
        System.out.println(acc);


    }
}
