package learn.ch27_lambda;

public class ThreadDemo {
    public static void main(String[] args) {
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
