package learn.ch16_inner;

public class StaticInnerDemo {
    private int id =1;
    private static int sid = 2;

    public static class StaticInner{
        private int sidId = 3;
        private static int sid = 4;

        public StaticInner(){
            System.out.println("静态内部类StaticInner的构造方法");
        }

        public void show(){
            System.out.println("外部类StaticInnerDemo的静态成员变量sid值是： "+ sid);
            System.out.println("静态内部类StaticInner的静态成员变量sidID值是： "+ sidId);
        }

        public void show2(int sid ){
            System.out.println("形参变量sid： "+ sid);
            System.out.println("静态内部类StaticInner的静态成员变量sidID值是： "+ StaticInner.sid);
            System.out.println("外部类StaticInnerDemo的静态成员变量sid值是： "+ StaticInnerDemo.sid);
        }
    }
}
