package com.enumPro;


interface Person{};
// 1、Java中为单继承，枚举已经隐含继承了java.lang.Enum， 可以实现接口
public enum Sex implements Person{
    MAN(1), WOMEN(2);
    private int value;
    // 构造函数
    // 2、枚举的构造函数不能用public修饰，
    //  如果其含有public构造器，那么在类的外部就可以通过这个构造器来新建实例
    //  显然这与实例的数量和值就不钩钉了，这与定义枚举类的初衷相矛盾，为了避免这种现象，就对其枚举类的构造器默认使用private修饰
    //  如果为枚举类的构造器显示指定其它访问控制符，则会编译出错
    Sex(){};
    Sex(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
