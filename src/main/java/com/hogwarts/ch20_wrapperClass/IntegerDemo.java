package com.hogwarts.ch20_wrapperClass;

/**
 * Integer:
 *      实现对int类型的包装
 *      提供int类型到String类之间的转换等方式
 *      方法：
 *          Integer(int value) 参数构造方法 过时
 *          static String toString(int i) 重写
 *          static Integer valueOf(int i) int -> Integer
 *          static Integer valueOf(String s) String -> Integer
 *          int intValue() Integer -> int
 *          static int parseInt(String s) String -> int
 *      装箱：int类型转换为Integer(基本数据类型转换成包装类)
 *      拆箱：从Integer转换为int类型(从包装类转换为基本数据类型)
 *      自动装箱和自动拆箱：自动装箱池：-128~127无需装箱直接取用自动装想池中的对象
 *      总结：
 *          基本数据类型转换为对应包装类的方式：调用包装类的构造方法活静态方法valueOf()
 *          获取包装类对象中基本数据类型变量数值：调用包装类中的xxxValue方法
 *          字符串转换为基本数据类型的方式：调用基本数据类型对应的包装类中的parseXxx方法
 */
public class IntegerDemo {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.TYPE);
        System.out.println("-----------构造方法声明-----------------");
        Integer integer1 = new Integer(19);
        Integer integer2 = new Integer("22");
        System.out.println(integer1);
        System.out.println(integer2);

        int i1 = 99;
        Integer integer3 = Integer.valueOf(i1);
        Integer integer4 = Integer.valueOf("88");
        System.out.println(integer3);
        System.out.println(integer4);

        int i = integer1.intValue();
        System.out.println(i);

        String s1 = "888";
        int i2 = Integer.parseInt(s1);
        System.out.println(i2);

    }
}
