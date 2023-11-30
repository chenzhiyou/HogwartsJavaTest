package com;

import com.hogwarts.ceshiren.Data;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import java.util.Date;

public class today {
    public static void main(String[] args) {
        LocalDate currentData = LocalDate.now();
        LocalDate yesterday = currentData.minusDays(1);
        System.out.println(yesterday.isBefore(currentData));
    }
}
