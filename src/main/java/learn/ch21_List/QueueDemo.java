package learn.ch21_List;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue queue = new LinkedList();
        for (int i = 1; i<6; i++){
            queue.offer(i*11);
        }
        System.out.println("队列元素为： "+ queue);
        System.out.println("队首元素为： "+ queue.peek());
        int size = queue.size();
        for (int i =0; i<size; i++){
            Object poll = queue.poll();
            System.out.println("出队元素为： "+poll);
        }
        System.out.println("队列元素为： "+ queue);
    }
}
