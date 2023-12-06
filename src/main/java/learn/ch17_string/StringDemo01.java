package learn.ch17_string;

import java.util.Locale;

public class StringDemo01 {
    public static void main(String[] args) {
        String str1 = "Hogwarts";
        char data[] = {'H', 'o', 'g','w','a', 'r','t','s'};
        String str2 = new String(data);
        System.out.println(str1.toLowerCase());
        System.out.println(str1.toUpperCase());
        String str3 = "   Hogwarts    ";
        System.out.println(str3.trim());
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));
    }
}
