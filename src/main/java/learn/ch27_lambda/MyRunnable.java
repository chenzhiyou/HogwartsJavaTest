package learn.ch27_lambda;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("线程启动成功了");
    }
}
