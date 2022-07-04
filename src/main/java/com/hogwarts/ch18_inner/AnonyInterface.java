package com.hogwarts.ch18_inner;

/**
 * 回调模式：
 *      接口回调
 *          某方法的参数是接口类型，调用该方法时，需要创建并传递一个实现此接口类型的对象，运行时会调用参数对象中所实现的方法
 *      步骤：
 *          创建回调接口
 *          创建回调接口实现类
 *          创建测试类并调用回调接口方法
 */
public interface AnonyInterface {
    public abstract void show();
}
