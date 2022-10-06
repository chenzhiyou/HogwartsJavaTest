package com.collectionPro;

// 定义带有泛型的类
public class PointGeneric<T> {
    private T x;
    private T y;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    // 定义含有泛型的方法
    public static <M> void getValue(M m){
        if (m instanceof String){
            System.out.println("m: "+ m);
        }

    }
}
