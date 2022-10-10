package com.threadPro;

class Ticket implements Runnable{
    private int ticket = 100;
    Object lock = new Object();

    @Override
    public void run() {
        while (true){// 只要有票，就一直卖
            // 使用同步代码块解决线程安全问题
            /**
             * synchronized(临时资源对象){ 对临界资源对象加锁
             *     代码(原子操作)
             * }
             */
            synchronized (Ticket.class){ // 每次只会允许一个线程进来执行里面的代码 .class文件加载到内存的时候，只会创建一个Class类的对象
                if (ticket > 0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+ "卖了第"+ticket--);
                }
            }

        }
    }

    // 使用synchronized 来修饰方法， 有锁，this
    public synchronized void sellTicket(){
        if (ticket > 0){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ "卖了第"+ticket--);
        }
    }
}
// 线程安全
public class ThreadSafe {
    public static void main(String[] args) {
        // 启动是三个窗口
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(ticket, "窗口1");
        Thread t2 = new Thread(ticket, "窗口2");
        Thread t3 = new Thread(ticket, "窗口3");
        t1.start();
        t2.start();
        t3.start();

    }
}
