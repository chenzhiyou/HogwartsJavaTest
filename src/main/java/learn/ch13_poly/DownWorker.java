package learn.ch13_poly;

public class DownWorker implements Person{
    @Override
    public void run() {
        System.out.println("Worker在跑步");
    }

    public void work(){
        System.out.println("worker在工作");
    }
}
