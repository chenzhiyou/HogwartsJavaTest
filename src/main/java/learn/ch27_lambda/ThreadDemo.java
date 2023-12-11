package learn.ch27_lambda;

import com.jayway.jsonpath.internal.function.numeric.Sum;

public class ThreadDemo {

    public static void testAdd(SumInterface sumInterface, int a, int b){
        sumInterface.add(a,b);
    }

    public static void testSub(SubInterface subInterface, int a, int b){
        subInterface.sub(a,b);
    }
    public static void main(String[] args) {

        SumInterface sum = (int a, int b )->{
            int i = a+b;
            System.out.println(a+ "+ "+ b + "= " + i);
        };
        testAdd(sum, 3,4);

        SubInterface sub = (int a, int b) ->{
            int i = a-b;
            System.out.println(a+ "- "+ b + "= " + i);
            return i;
        };

        testSub(sub, 3, 2);
        // 1、实现Runnable接口
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();

        // 2、匿名内部类启动线程
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部的线程接口");
            }
        });
        thread1.start();

        // 3、使用lambda表达式 (形式参数)->{方法体;}
        Thread thread2 = new Thread(()->{System.out.println("lambda的线程接口");});
        thread2.start();
    }
}
