package learn.ch30_random;

import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomDemo {
    public static void main(String[] args) {
        // 实例化对象
        Random random = new Random();
        System.out.println("生成伪随机整数： "+ random.nextInt());

        // 实例化Random对象(有参构造)，seed随机算法的起源数字,同一个种子，相同次数生成的随机数字是完全相同的
        Random random1 = new Random(666);
        Random random2 = new Random(666);
        System.out.println("生成伪随机整数： "+ random1.nextInt());
        System.out.println("生成伪随机整数： "+ random2.nextInt());
        System.out.println(random.nextDouble());
        System.out.println(random.nextFloat());
        System.out.println(random.nextBoolean());
        // 通过迭代器的方式获取随机数
        IntStream ins = random.ints(10,100);
        PrimitiveIterator.OfInt iterator = ins.iterator();
        System.out.println(iterator.next());
    }
}
