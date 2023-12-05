package learn.ch16_inner;

public class AnnoyClass {
    public static void annoyTest(AnnoyInterface annoyInterface){
        annoyInterface.show();
    }

    public static void main(String[] args) {
        // 直接创建接口实现类
        AnnoyClass.annoyTest(new AnnoyInterfaceImpl());

        // 匿名内部类实现对象接口方法
        AnnoyClass.annoyTest(new AnnoyInterface() {
            @Override
            public void show() {
                System.out.println("匿名内部类实现AnnoyInterface接口");
            }
        });

        // lambda表达式+匿名内部类
        //格式 (参数)->{方法体}
        AnnoyInterface annoyTest1 = ()-> System.out.println("lambda表达式声明匿名内部类");
        AnnoyClass.annoyTest(annoyTest1);
    }
}
