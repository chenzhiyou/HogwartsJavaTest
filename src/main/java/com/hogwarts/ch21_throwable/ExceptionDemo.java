package com.hogwarts.ch21_throwable;

/**
 * 合理的应用程序可能需要捕获的问题
 *      可以预料的问题
 * 异常的处理方式：
 *      try(尝试执行的代码)...catch(出现可能异常之后的处理代码)...finally(里面的代码一定会执行，主要做资源回收关闭操作)
 *      特点：处理完异常之后程序是会继续执行的
 *      finally:正常情况下，无论怎样finally代码块内容都会被执行
 *      throws
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        try{
            int a = 16/0;
        }catch (Exception e){
            System.out.println(e);
        }finally {
            System.out.println("执行结束");
        }
        System.out.println("ending");
    }
}
