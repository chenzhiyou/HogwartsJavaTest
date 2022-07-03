package com.hogwarts.ch18_inner;

/**
 * 局部内部类：
 *      访问修饰符 class 外部类的类名{
 *          访问修饰符 返回值类型 成员方法名 (形参列表){
 *              class 内部类的类名{
 *                  内部类的实体;
 *              }
 *          }
 *      }
 *      方法内调用： 局部内部类类名 局部内部类实例名 = new 局部内部类类名();
 *                 局部内部类实例名.内部类方法名();
 *      特点：
 *          局部内部类只能在方法的内部可以使用
 *          局部内部类可以在方法体内部直接创建对应对象
 */
public class AreaInnerClassDemo {
    private int aid = 2;
    public void show(){
        class AreaInner{
            private int id =1;
            public AreaInner(){
                System.out.println("局部内部类AreaInner的构造方法");
            }

            public void testArea(){
                System.out.println("局部内部类AreaInner的ID的值："+ id);
                System.out.println("AreaInnerClassDemo的aid的值： "+ aid);
            }
        }
        AreaInner areaInner = new AreaInner();
        areaInner.testArea();
    }
}
