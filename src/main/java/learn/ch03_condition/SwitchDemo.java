package learn.ch03_condition;

public class SwitchDemo {
    public static void main(String[] args) {
        int weekday = 6;
        switch (weekday){
            case 1:
                System.out.println("周一");
                break;
            case 2:
                System.out.println("周二");
                break;
            case 3:
                System.out.println("周三");
                break;
            case 4:
                System.out.println("周四");
                break;
            case 5:
                System.out.println("周五");
                break;
            default:
                System.out.println("周末");
        }
    }
}
