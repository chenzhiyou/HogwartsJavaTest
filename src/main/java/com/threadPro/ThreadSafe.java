package com.threadPro;

class Ticket implements Runnable{
    private int ticket = 100;

    @Override
    public void run() {
        while (true){// 只要有票，就一直卖
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (ticket > 0){
                System.out.println(Thread.currentThread().getName()+ "卖了第"+ticket--);
            }


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
