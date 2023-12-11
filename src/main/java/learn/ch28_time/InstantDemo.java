package learn.ch28_time;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class InstantDemo {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println("当前时间: "+ now);
        // 添加时间偏移
        OffsetDateTime odt = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);
    }
}
