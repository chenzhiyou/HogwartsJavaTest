package learn.ch18_langp;

public class DoubleDemo {
    public static void main(String[] args) {
        Double d1 = new Double(7.9);
        Double d2 = new Double("10.2");

        System.out.println(d1);
        System.out.println(d2);

        System.out.println(Double.valueOf(7.8));
        System.out.println(Double.valueOf("10.1"));
        System.out.println(Double.isNaN(d2));
    }
}

