package com.collectionPro;

class DoorImpl implements DoorGeneric<String>{

    @Override
    public String getType() {
        return null;
    }
}

class DoorImpl2 implements DoorGeneric<Integer>{

    @Override
    public Integer getType() {
        return null;
    }
}
// 定义含有泛型的接口，实现这个接口的时候可以确定泛型的类型
public interface DoorGeneric<T> {
    T getType();
}
